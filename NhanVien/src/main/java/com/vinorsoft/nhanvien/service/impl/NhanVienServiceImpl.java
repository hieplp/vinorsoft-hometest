package com.vinorsoft.nhanvien.service.impl;

import com.vinorsoft.nhanvien.common.enums.IdLength;
import com.vinorsoft.nhanvien.common.enums.UserStatus;
import com.vinorsoft.nhanvien.common.exception.NotFoundException;
import com.vinorsoft.nhanvien.common.exception.nhanvien.DuplicatedEmailException;
import com.vinorsoft.nhanvien.common.exception.nhanvien.DuplicatedPhoneException;
import com.vinorsoft.nhanvien.common.payload.request.CommonGetRequest;
import com.vinorsoft.nhanvien.common.payload.response.CommonGetResponse;
import com.vinorsoft.nhanvien.common.util.GeneratorUtil;
import com.vinorsoft.nhanvien.payload.request.nhanvien.CreateNhanVienRequest;
import com.vinorsoft.nhanvien.payload.request.nhanvien.UpdateNhanVienRequest;
import com.vinorsoft.nhanvien.payload.response.nhanvien.CommonNhanVienResponse;
import com.vinorsoft.nhanvien.payload.response.nhanvien.CreateNhanVienResponse;
import com.vinorsoft.nhanvien.payload.response.nhanvien.GetNhanVienResponse;
import com.vinorsoft.nhanvien.payload.response.nhanvien.UpdateNhanVienResponse;
import com.vinorsoft.nhanvien.repository.ChucVuRepository;
import com.vinorsoft.nhanvien.repository.NhanVienRepository;
import com.vinorsoft.nhanvien.repository.PhongBanRepository;
import com.vinorsoft.nhanvien.repository.generate.tables.records.NhanVienRecord;
import com.vinorsoft.nhanvien.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {


    private final NhanVienRepository nhanVienRepository;
    private final ChucVuRepository chucVuRepository;
    private final PhongBanRepository phongBanRepository;

    @Override
    @Transactional
    public CreateNhanVienResponse createNhanVien(CreateNhanVienRequest request) {
        log.info("Create nhanVien with request: {}", request);

        if (!chucVuRepository.existsById(request.getChucVuId())) {
            log.error("Chuc vu with id {} not found", request.getChucVuId());
            throw new NotFoundException(String.format("Chuc vu with id %s not found", request.getChucVuId()));
        }

        if (!phongBanRepository.existsById(request.getPhongBanId())) {
            log.error("Phong ban with id {} not found", request.getPhongBanId());
            throw new NotFoundException(String.format("Phong ban with id %s not found", request.getPhongBanId()));
        }

        if (nhanVienRepository.existsByEmail(request.getEmail())) {
            log.error("Email {} already exists", request.getEmail());
            throw new DuplicatedEmailException(String.format("Email %s already exists", request.getEmail()));
        }

        if (nhanVienRepository.existsBySdt(request.getSdt())) {
            log.error("Sdt {} already exists", request.getSdt());
            throw new DuplicatedPhoneException(String.format("Sdt %s already exists", request.getSdt()));
        }

        var nhanVien = new NhanVienRecord()
                .setMaNhanVien(GeneratorUtil.generateNumId(IdLength.EMPLOYEE_ID))
                .setHoVaTen(request.getHoVaTen())
                .setNgaySinh(request.getNgaySinh())
                .setQueQuan(request.getQueQuan())
                .setEmail(request.getEmail())
                .setSdt(request.getSdt())
                .setPhongBanId(request.getPhongBanId())
                .setChucVuId(request.getChucVuId())
                .setLuong(request.getLuong())
                .setTrangThai(UserStatus.ACTIVE.getStatus());
        nhanVienRepository.save(nhanVien);

        var response = new CreateNhanVienResponse();
        nhanVien.into(response);
        return response;
    }

    @Override
    @Transactional
    public UpdateNhanVienResponse updateNhanVien(String maNhanVien, UpdateNhanVienRequest request) {
        log.info("Update nhanVien: {} with request: {}", maNhanVien, request);

        var nhanVien = nhanVienRepository.findByMaNhanVien(maNhanVien)
                .orElseThrow(() -> new NotFoundException("NhanVien not found"));

        if (!nhanVien.getPhongBanId().equals(request.getPhongBanId()) && !phongBanRepository.existsById(request.getPhongBanId())) {
            log.error("Phong ban with id {} not found", request.getPhongBanId());
            throw new NotFoundException(String.format("Phong ban with id %s not found", request.getPhongBanId()));
        }

        if (!nhanVien.getChucVuId().equals(request.getChucVuId()) && !chucVuRepository.existsById(request.getChucVuId())) {
            log.error("Chuc vu with id {} not found", request.getChucVuId());
            throw new NotFoundException(String.format("Chuc vu with id %s not found", request.getChucVuId()));
        }

        if (!nhanVien.getEmail().equals(request.getEmail()) && nhanVienRepository.existsByEmail(request.getEmail())) {
            log.error("Email {} already exists", request.getEmail());
            throw new DuplicatedEmailException(String.format("Email %s already exists", request.getEmail()));
        }

        if (!nhanVien.getSdt().equals(request.getSdt()) && nhanVienRepository.existsBySdt(request.getSdt())) {
            log.error("Sdt {} already exists", request.getSdt());
            throw new DuplicatedEmailException(String.format("Sdt %s already exists", request.getSdt()));
        }

        nhanVien
                .setHoVaTen(request.getHoVaTen())
                .setNgaySinh(request.getNgaySinh())
                .setQueQuan(request.getQueQuan())
                .setEmail(request.getEmail())
                .setSdt(request.getSdt())
                .setPhongBanId(request.getPhongBanId())
                .setChucVuId(request.getChucVuId())
                .setLuong(request.getLuong());
        if (request.getTrangThai() != null) {
            UserStatus.validate(request.getTrangThai());
            nhanVien.setTrangThai(request.getTrangThai());
        }
        nhanVienRepository.updateNotNull(nhanVien);

        var response = new UpdateNhanVienResponse();
        nhanVien.into(response);
        return response;
    }

    @Override
    public GetNhanVienResponse getNhanVien(String maNhanVien) {
        log.info("Get nhanVien: {}", maNhanVien);
        var nhanVien = nhanVienRepository.findByMaNhanVien(maNhanVien)
                .orElseThrow(() -> new NotFoundException("NhanVien not found"));
        var response = new GetNhanVienResponse();
        nhanVien.into(response);
        return response;
    }

    @Override
    @Transactional
    public void deleteNhanVien(String maNhanVien) {
        log.info("Delete nhanVien: {}", maNhanVien);
        var nhanVien = nhanVienRepository.findByMaNhanVien(maNhanVien)
                .orElseThrow(() -> new NotFoundException("NhanVien not found"));
        nhanVienRepository.delete(nhanVien);
    }

    @Override
    public List<CommonNhanVienResponse> getListOfNhanVien(CommonGetRequest request) {
        log.info("Get list of nhanVien with request: {}", request);
        return nhanVienRepository.getListOfNhanVien(request, CommonNhanVienResponse.class);
    }

    @Override
    public CommonGetResponse<CommonNhanVienResponse> getPagingListOfNhanVien(CommonGetRequest request) {
        log.info("Get paging list of nhanVien with request: {}", request);
        return nhanVienRepository.getPagingListOfNhanVien(request, CommonNhanVienResponse.class);
    }

    @Override
    public void updateSalaryOfNhanVien(Map<String, Long> salaries) {
        log.info("Update salary of nhanVien with request: {}", salaries);
        for (var entry : salaries.entrySet()) {
            var optionalNhanVien = nhanVienRepository.findByMaNhanVien(entry.getKey());
            if (optionalNhanVien.isEmpty()) {
                log.error("NhanVien with maNhanVien {} not found", entry.getKey());
                continue;
            }

            var nhanVien = optionalNhanVien.get();
//            nhanVien.setLuong(entry.getValue());
            nhanVienRepository.updateNotNull(nhanVien);
        }
    }
}
