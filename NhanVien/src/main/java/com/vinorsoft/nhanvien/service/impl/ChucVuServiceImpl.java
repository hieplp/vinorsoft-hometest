package com.vinorsoft.nhanvien.service.impl;

import com.vinorsoft.nhanvien.common.enums.IdLength;
import com.vinorsoft.nhanvien.common.exception.NotFoundException;
import com.vinorsoft.nhanvien.common.exception.role.DuplicatedRoleException;
import com.vinorsoft.nhanvien.common.util.GeneratorUtil;
import com.vinorsoft.nhanvien.payload.request.chucvu.CreateChucVuRequest;
import com.vinorsoft.nhanvien.payload.request.chucvu.UpdateChucVuRequest;
import com.vinorsoft.nhanvien.payload.response.chucvu.CreateChucVuResponse;
import com.vinorsoft.nhanvien.payload.response.chucvu.GetChucVuResponse;
import com.vinorsoft.nhanvien.payload.response.chucvu.UpdateChucVuResponse;
import com.vinorsoft.nhanvien.repository.ChucVuRepository;
import com.vinorsoft.nhanvien.repository.NhanVienRepository;
import com.vinorsoft.nhanvien.repository.generate.tables.records.ChucVuRecord;
import com.vinorsoft.nhanvien.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChucVuServiceImpl implements ChucVuService {

    private final ChucVuRepository chucVuRepository;
    private final NhanVienRepository nhanVienRepository;

    @Override
    @Transactional
    public CreateChucVuResponse createChucVu(CreateChucVuRequest request) {
        log.info("Create chucVu with request: {}", request);

        if (chucVuRepository.existsByTenChucVu(request.getTenChucVu())) {
            log.error("tenChucVu: {} is duplicated", request.getTenChucVu());
            throw new DuplicatedRoleException(String.format("tenChucVu: %s is duplicated", request.getTenChucVu()));
        }

        var chucVu = new ChucVuRecord()
                .setChucVuId(GeneratorUtil.generateId(IdLength.ROLE_ID))
                .setTenChucVu(request.getTenChucVu())
                .setThamQuyen(request.getThamQuyen());
        chucVuRepository.save(chucVu);

        var response = new CreateChucVuResponse();
        chucVu.into(response);
        return response;
    }

    @Override
    @Transactional
    public UpdateChucVuResponse updateChucVu(String chucVuId, UpdateChucVuRequest request) {
        log.info("Update chucVu: {} with request: {}", chucVuId, request);

        var chucVu = chucVuRepository.findById(chucVuId)
                .orElseThrow(() -> new NotFoundException("chucVu not found"));

        if (!chucVu.getTenChucVu().equals(request.getTenChucVu())
                && chucVuRepository.existsByTenChucVu(request.getTenChucVu())) {
            log.error("tenChucVu: {} is duplicated", request.getTenChucVu());
            throw new DuplicatedRoleException(String.format("tenChucVu: %s is duplicated", request.getTenChucVu()));
        }

        chucVu
                .setTenChucVu(request.getTenChucVu())
                .setThamQuyen(request.getThamQuyen());
        chucVuRepository.updateNotNull(chucVu);

        var response = new UpdateChucVuResponse();
        chucVu.into(response);
        return response;
    }

    @Override
    public GetChucVuResponse getChucVu(String chucVuId) {
        log.info("Get chucVu: {}", chucVuId);
        var chucVu = chucVuRepository.findById(chucVuId)
                .orElseThrow(() -> new NotFoundException("chucVu not found"));
        var response = new GetChucVuResponse();
        chucVu.into(response);
        return response;
    }

    @Override
    @Transactional
    public void deleteRole(String chucVuId) {
        log.info("Delete chucVu: {}", chucVuId);

        var chucVu = chucVuRepository.findById(chucVuId)
                .orElseThrow(() -> new NotFoundException("chucVu not found"));

        var totalNhanVien = nhanVienRepository.countNhanVienByChucVuId(chucVuId);
        if (totalNhanVien > 0) {
            log.error("chucVu: {} has {} nhanVien", chucVuId, totalNhanVien);
            throw new DuplicatedRoleException(String.format("chucVu: %s has %d nhanVien", chucVuId, totalNhanVien));
        }

        chucVuRepository.delete(chucVu);
    }
}
