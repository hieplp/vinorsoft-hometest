package com.vinorsoft.nhanvien.service;

import com.vinorsoft.nhanvien.payload.request.role.CreateRoleRequest;
import com.vinorsoft.nhanvien.payload.request.role.UpdateRoleRequest;
import com.vinorsoft.nhanvien.payload.response.role.CreateRoleResponse;
import com.vinorsoft.nhanvien.payload.response.role.GetRoleResponse;
import com.vinorsoft.nhanvien.payload.response.role.UpdateRoleResponse;

public interface RoleService {
    CreateRoleResponse createRole(CreateRoleRequest request);

    UpdateRoleResponse updateRole(String chucVuId, UpdateRoleRequest request);

    GetRoleResponse getRole(String chucVuId);

    void deleteRole(String chucVuId);
}
