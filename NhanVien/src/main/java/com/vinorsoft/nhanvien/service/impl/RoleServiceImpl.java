package com.vinorsoft.nhanvien.service.impl;

import com.vinorsoft.nhanvien.common.entity.ChucVu;
import com.vinorsoft.nhanvien.common.enums.IdLength;
import com.vinorsoft.nhanvien.common.exception.NotFoundException;
import com.vinorsoft.nhanvien.common.exception.role.DuplicatedRoleException;
import com.vinorsoft.nhanvien.common.util.GeneratorUtil;
import com.vinorsoft.nhanvien.payload.request.role.CreateRoleRequest;
import com.vinorsoft.nhanvien.payload.request.role.UpdateRoleRequest;
import com.vinorsoft.nhanvien.payload.response.role.CreateRoleResponse;
import com.vinorsoft.nhanvien.payload.response.role.GetRoleResponse;
import com.vinorsoft.nhanvien.payload.response.role.UpdateRoleResponse;
import com.vinorsoft.nhanvien.repository.ChucVuRepository;
import com.vinorsoft.nhanvien.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final ChucVuRepository chucVuRepository;

    @Override
    public CreateRoleResponse createRole(CreateRoleRequest request) {
        log.info("Create role with request: {}", request);

        if (chucVuRepository.existsByTenChucVu(request.getTenChucVu())) {
            throw new DuplicatedRoleException("tenChucVu already exists");
        }

        var roleEntity = ChucVu.builder()
                .chucVuId(GeneratorUtil.generateId(IdLength.ROLE_ID))
                .tenChucVu(request.getTenChucVu())
                .thamQuyen(request.getThamQuyen())
                .build();
        chucVuRepository.save(roleEntity);

        var response = new CreateRoleResponse();
        BeanUtils.copyProperties(roleEntity, response);
        return response;
    }

    @Override
    public UpdateRoleResponse updateRole(String chucVuId, UpdateRoleRequest request) {
        log.info("Update role: {} with request: {}", chucVuId, request);

        var roleEntity = chucVuRepository.findById(chucVuId)
                .orElseThrow(() -> new NotFoundException("Role not found"));

        if (!roleEntity.getTenChucVu().equals(request.getTenChucVu())
                && chucVuRepository.existsByTenChucVu(request.getTenChucVu())) {
            throw new DuplicatedRoleException("tenChucVu already exists");
        }

        roleEntity.setTenChucVu(request.getTenChucVu());
        roleEntity.setThamQuyen(request.getThamQuyen());
        chucVuRepository.save(roleEntity);

        var response = new UpdateRoleResponse();
        BeanUtils.copyProperties(roleEntity, response);
        return response;
    }

    @Override
    public GetRoleResponse getRole(String chucVuId) {
        log.info("Get role: {}", chucVuId);
        var roleEntity = chucVuRepository.findById(chucVuId)
                .orElseThrow(() -> new NotFoundException("Role not found"));
        var response = new GetRoleResponse();
        BeanUtils.copyProperties(roleEntity, response);
        return response;
    }

    @Override
    public void deleteRole(String chucVuId) {
        log.info("Delete role: {}", chucVuId);
        var roleEntity = chucVuRepository.findById(chucVuId)
                .orElseThrow(() -> new NotFoundException("Role not found"));
        chucVuRepository.delete(roleEntity);
    }
}
