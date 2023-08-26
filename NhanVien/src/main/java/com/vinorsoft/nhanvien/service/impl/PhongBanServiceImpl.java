package com.vinorsoft.nhanvien.service.impl;

import com.vinorsoft.nhanvien.common.enums.IdLength;
import com.vinorsoft.nhanvien.common.exception.BadRequestException;
import com.vinorsoft.nhanvien.common.exception.NotFoundException;
import com.vinorsoft.nhanvien.common.exception.department.DuplicatedDepartmentException;
import com.vinorsoft.nhanvien.common.util.GeneratorUtil;
import com.vinorsoft.nhanvien.payload.request.phongban.CreatePhongBanRequest;
import com.vinorsoft.nhanvien.payload.request.phongban.UpdatePhongBanRequest;
import com.vinorsoft.nhanvien.payload.response.phongban.CreatePhongBanResponse;
import com.vinorsoft.nhanvien.payload.response.phongban.GetPhongBanResponse;
import com.vinorsoft.nhanvien.payload.response.phongban.UpdatePhongBanResponse;
import com.vinorsoft.nhanvien.repository.NhanVienRepository;
import com.vinorsoft.nhanvien.repository.PhongBanRepository;
import com.vinorsoft.nhanvien.repository.generate.tables.records.PhongBanRecord;
import com.vinorsoft.nhanvien.service.PhongBanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhongBanServiceImpl implements PhongBanService {


    private final PhongBanRepository phongBanRepository;
    private final NhanVienRepository nhanVienRepository;

    @Override
    @Transactional
    public CreatePhongBanResponse createPhongBan(CreatePhongBanRequest request) {
        log.info("Create phongBan with request: {}", request);

        if (phongBanRepository.existsByTenPhongBan(request.getTenPhongBan())) {
            log.error("tenPhongBan: {} is duplicated", request.getTenPhongBan());
            throw new DuplicatedDepartmentException(String.format("tenPhongBan: %s is duplicated", request.getTenPhongBan()));
        }

        var phongBan = new PhongBanRecord()
                .setPhongBanId(GeneratorUtil.generateId(IdLength.DEPARTMENT_ID))
                .setTenPhongBan(request.getTenPhongBan())
                .setChucNang(request.getChucNang());
        phongBanRepository.save(phongBan);

        var response = new CreatePhongBanResponse();
        phongBan.into(response);
        return response;
    }

    @Override
    @Transactional
    public UpdatePhongBanResponse updatePhongBan(String phongBanId, UpdatePhongBanRequest request) {
        log.info("Update phongBan: {} with request: {}", phongBanId, request);

        var phongBan = phongBanRepository.findById(phongBanId)
                .orElseThrow(() -> new NotFoundException("PhongBan not found"));

        if (!phongBan.getTenPhongBan().equals(request.getTenPhongBan())
                && phongBanRepository.existsByTenPhongBan(request.getTenPhongBan())) {
            log.error("tenPhongBan: {} is duplicated", request.getTenPhongBan());
            throw new DuplicatedDepartmentException(String.format("tenPhongBan: %s is duplicated", request.getTenPhongBan()));
        }

        phongBan.setTenPhongBan(request.getTenPhongBan());
        phongBan.setChucNang(request.getChucNang());
        phongBanRepository.updateNotNull(phongBan);

        var response = new UpdatePhongBanResponse();
        BeanUtils.copyProperties(phongBan, response);
        return response;
    }

    @Override
    public GetPhongBanResponse getPhongBan(String phongBanId) {
        log.info("Get phongBan: {}", phongBanId);
        var phongBan = phongBanRepository.findById(phongBanId)
                .orElseThrow(() -> new NotFoundException("PhongBan not found"));
        var response = new GetPhongBanResponse();
        phongBan.into(response);
        return response;
    }

    @Override
    @Transactional
    public void deletePhongBan(String phongBanId) {
        log.info("Delete phongBan: {}", phongBanId);

        var phongBan = phongBanRepository.findById(phongBanId)
                .orElseThrow(() -> new NotFoundException("PhongBan not found"));

        var totalNhanVien = nhanVienRepository.countNhanVienByPhongBanId(phongBanId);
        if (totalNhanVien > 0) {
            log.error("PhongBan: {} has {} nhanVien", phongBanId, totalNhanVien);
            throw new BadRequestException(String.format("PhongBan: %s has %d nhanVien", phongBanId, totalNhanVien));
        }

        phongBanRepository.delete(phongBan);
    }
}
