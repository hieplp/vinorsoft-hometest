package com.vinorsoft.nhanvien.repository;

import com.vinorsoft.nhanvien.common.payload.request.CommonGetRequest;
import com.vinorsoft.nhanvien.common.payload.response.CommonGetResponse;
import com.vinorsoft.nhanvien.repository.base.BaseRepo;
import com.vinorsoft.nhanvien.repository.generate.tables.records.NhanVienRecord;

import java.util.List;
import java.util.Optional;

public interface NhanVienRepository extends BaseRepo {
    boolean existsByEmail(String email);

    boolean existsBySdt(String sdt);

    Optional<NhanVienRecord> findByMaNhanVien(String maNhanVien);

    int countNhanVienByPhongBanId(String phongBanId);

    int countNhanVienByChucVuId(String chucVuId);

    <T> List<T> getListOfNhanVien(CommonGetRequest request, Class<T> returnType);

    <T> CommonGetResponse<T> getPagingListOfNhanVien(CommonGetRequest request, Class<T> returnType);
}
