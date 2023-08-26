package com.vinorsoft.nhanvien.service;

import com.vinorsoft.nhanvien.common.payload.request.CommonGetRequest;
import com.vinorsoft.nhanvien.common.payload.response.CommonGetResponse;
import com.vinorsoft.nhanvien.payload.request.nhanvien.CreateNhanVienRequest;
import com.vinorsoft.nhanvien.payload.request.nhanvien.UpdateNhanVienRequest;
import com.vinorsoft.nhanvien.payload.response.nhanvien.CommonNhanVienResponse;
import com.vinorsoft.nhanvien.payload.response.nhanvien.CreateNhanVienResponse;
import com.vinorsoft.nhanvien.payload.response.nhanvien.GetNhanVienResponse;
import com.vinorsoft.nhanvien.payload.response.nhanvien.UpdateNhanVienResponse;

import java.util.List;
import java.util.Map;

public interface NhanVienService {
    CreateNhanVienResponse createNhanVien(CreateNhanVienRequest request);

    UpdateNhanVienResponse updateNhanVien(String maNhanVien, UpdateNhanVienRequest request);

    GetNhanVienResponse getNhanVien(String maNhanVien);

    void deleteNhanVien(String maNhanVien);

    List<CommonNhanVienResponse> getListOfNhanVien(CommonGetRequest request);

    CommonGetResponse<CommonNhanVienResponse> getPagingListOfNhanVien(CommonGetRequest request);

    void updateSalaryOfNhanVien(Map<String, Long> salaries);
}
