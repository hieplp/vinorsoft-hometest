package com.vinorsoft.giamdoc.service.impl;

import com.vinorsoft.giamdoc.common.exception.BadRequestException;
import com.vinorsoft.giamdoc.common.exception.StorageException;
import com.vinorsoft.giamdoc.config.AppConfig;
import com.vinorsoft.giamdoc.payload.request.UpdateSalaryOfNhanVienRequest;
import com.vinorsoft.giamdoc.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final Path rootLocation = Paths.get("upload-dir");

    private final AppConfig appConfig;

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }

            var pattern = Pattern.compile("^BangLuongThang_(\\d{1,2})_(\\d{4})\\.xlsx$");
            var matcher = pattern.matcher(Objects.requireNonNull(file.getOriginalFilename()));
            if (!matcher.matches()) {
                throw new BadRequestException("Failed to store file: invalid file name or type.");
            }

            var path = Paths.get(Objects.requireNonNull(file.getOriginalFilename()));
            var destinationFile = this.rootLocation.resolve(path).normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new StorageException("Cannot store file outside current directory.");
            }

            if (!Files.exists(this.rootLocation)) {
                Files.createDirectory(this.rootLocation);
            }

            try (var inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            log.error("Failed to store file: {}", e.getMessage());
            throw new StorageException(e.getMessage());
        }
    }

    @Scheduled(cron = "${app.cron}")
    @Override
    public void updateSalaryByMonth() {
        try {
            log.info("Updating salary by month");
            // Get the current date
            var currentDate = LocalDate.now();
            var currentMonth = currentDate.getMonth().getValue();
            var currentYear = currentDate.getYear();

            // Get the file name
            var fileName = String.format("BangLuongThang_%d_%d.xlsx", currentMonth, currentYear);
            var file = new File(this.rootLocation.resolve(fileName).normalize().toAbsolutePath().toString());
            if (!file.exists()) {
                log.info("File {} not found", fileName);
                return;
            }

            //
            var workbook = new XSSFWorkbook(file);
            var worksheet = workbook.getSheetAt(0);

            var map = new HashMap<String, Long>();

            for (int rowIndex = 1; rowIndex < worksheet.getPhysicalNumberOfRows(); rowIndex++) {
                var row = worksheet.getRow(rowIndex);
                var maNhanVien = row.getCell(0).getStringCellValue();
                var luong = row.getCell(3).getStringCellValue()
                        .replace(",", "");
                map.put(maNhanVien, Long.parseLong(luong));
            }

            var request = new UpdateSalaryOfNhanVienRequest();
            request.setSalaries(map);
            log.info("Request: {}", request);

            // TODO: Call via discovery service instead of directly
            var restTemplate = new RestTemplate();
            restTemplate.put(appConfig.getUpdateSalaryOfNhanVienUri(), request);

            workbook.close();
        } catch (IOException | InvalidFormatException e) {
            log.error("Failed to update salary by month: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
