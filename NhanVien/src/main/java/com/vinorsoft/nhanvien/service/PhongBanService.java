package com.vinorsoft.nhanvien.service;

import com.vinorsoft.nhanvien.payload.request.phongban.CreatePhongBanRequest;
import com.vinorsoft.nhanvien.payload.request.phongban.UpdatePhongBanRequest;
import com.vinorsoft.nhanvien.payload.response.phongban.CommonPhongBanResponse;
import com.vinorsoft.nhanvien.payload.response.phongban.CreatePhongBanResponse;
import com.vinorsoft.nhanvien.payload.response.phongban.GetPhongBanResponse;
import com.vinorsoft.nhanvien.payload.response.phongban.UpdatePhongBanResponse;

import java.util.List;

public interface PhongBanService {
    CreatePhongBanResponse createPhongBan(CreatePhongBanRequest request);

    UpdatePhongBanResponse updatePhongBan(String phongBanId, UpdatePhongBanRequest request);

    GetPhongBanResponse getPhongBan(String phongBanId);

    void deletePhongBan(String phongBanId);

    List<CommonPhongBanResponse> getAllPhongBan();
}
