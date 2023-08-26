package com.vinorsoft.nhanvien.service.impl;

import com.vinorsoft.nhanvien.common.entity.PhongBan;
import com.vinorsoft.nhanvien.common.enums.IdLength;
import com.vinorsoft.nhanvien.common.exception.NotFoundException;
import com.vinorsoft.nhanvien.common.exception.department.DuplicatedDepartmentException;
import com.vinorsoft.nhanvien.common.util.GeneratorUtil;
import com.vinorsoft.nhanvien.payload.request.department.CreateDepartmentRequest;
import com.vinorsoft.nhanvien.payload.request.department.UpdateDepartmentRequest;
import com.vinorsoft.nhanvien.payload.response.department.CreateDepartmentResponse;
import com.vinorsoft.nhanvien.payload.response.department.GetDepartmentResponse;
import com.vinorsoft.nhanvien.payload.response.department.UpdateDepartmentResponse;
import com.vinorsoft.nhanvien.repository.PhongBanRepository;
import com.vinorsoft.nhanvien.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final PhongBanRepository phongBanRepository;

    @Override
    @Transactional
    public CreateDepartmentResponse createDepartment(CreateDepartmentRequest request) {
        log.info("Create department with request: {}", request);

        if (phongBanRepository.existsByTenPhongBan(request.getTenPhongBan())) {
            throw new DuplicatedDepartmentException("Department name is duplicated");
        }

        var departmentEntity = PhongBan.builder()
                .phongBanId(GeneratorUtil.generateId(IdLength.DEPARTMENT_ID))
                .tenPhongBan(request.getTenPhongBan())
                .chucNang(request.getChucNang())
                .build();
        phongBanRepository.save(departmentEntity);

        var response = new CreateDepartmentResponse();
        BeanUtils.copyProperties(departmentEntity, response);
        return response;
    }

    @Override
    public UpdateDepartmentResponse updateDepartment(String phongBanId, UpdateDepartmentRequest request) {
        log.info("Update department: {} with request: {}", phongBanId, request);

        var departmentEntity = phongBanRepository.findById(phongBanId)
                .orElseThrow(() -> new NotFoundException("Department not found"));

        if (!departmentEntity.getTenPhongBan().equals(request.getTenPhongBan())
                && phongBanRepository.existsByTenPhongBan(request.getTenPhongBan())) {
            throw new DuplicatedDepartmentException("Department name is duplicated");
        }

        departmentEntity.setTenPhongBan(request.getTenPhongBan());
        departmentEntity.setChucNang(request.getChucNang());
        phongBanRepository.save(departmentEntity);

        var response = new UpdateDepartmentResponse();
        BeanUtils.copyProperties(departmentEntity, response);
        return response;
    }

    @Override
    public GetDepartmentResponse getDepartment(String phongBanId) {
        log.info("Get department: {}", phongBanId);
        var departmentEntity = phongBanRepository.findById(phongBanId)
                .orElseThrow(() -> new NotFoundException("Department not found"));
        var response = new GetDepartmentResponse();
        BeanUtils.copyProperties(departmentEntity, response);
        return response;
    }

    @Override
    public void deleteDepartment(String phongBanId) {
        log.info("Delete department: {}", phongBanId);
        var departmentEntity = phongBanRepository.findById(phongBanId)
                .orElseThrow(() -> new NotFoundException("Department not found"));
        phongBanRepository.delete(departmentEntity);
    }
}
