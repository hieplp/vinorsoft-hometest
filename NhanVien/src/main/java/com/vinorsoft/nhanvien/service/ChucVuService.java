package com.vinorsoft.nhanvien.service;

import com.vinorsoft.nhanvien.payload.request.chucvu.CreateChucVuRequest;
import com.vinorsoft.nhanvien.payload.request.chucvu.UpdateChucVuRequest;
import com.vinorsoft.nhanvien.payload.response.chucvu.CreateChucVuResponse;
import com.vinorsoft.nhanvien.payload.response.chucvu.GetChucVuResponse;
import com.vinorsoft.nhanvien.payload.response.chucvu.UpdateChucVuResponse;

public interface ChucVuService {
    CreateChucVuResponse createChucVu(CreateChucVuRequest request);

    UpdateChucVuResponse updateChucVu(String chucVuId, UpdateChucVuRequest request);

    GetChucVuResponse getChucVu(String chucVuId);

    void deleteRole(String chucVuId);
}
