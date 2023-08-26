package com.vinorsoft.nhanvien.service;

import com.vinorsoft.nhanvien.payload.request.department.CreateDepartmentRequest;
import com.vinorsoft.nhanvien.payload.request.department.UpdateDepartmentRequest;
import com.vinorsoft.nhanvien.payload.response.department.CreateDepartmentResponse;
import com.vinorsoft.nhanvien.payload.response.department.GetDepartmentResponse;
import com.vinorsoft.nhanvien.payload.response.department.UpdateDepartmentResponse;

public interface DepartmentService {
    CreateDepartmentResponse createDepartment(CreateDepartmentRequest request);

    UpdateDepartmentResponse updateDepartment(String phongBanId, UpdateDepartmentRequest request);

    GetDepartmentResponse getDepartment(String phongBanId);

    void deleteDepartment(String phongBanId);
}
