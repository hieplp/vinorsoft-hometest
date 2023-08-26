package com.vinorsoft.nhanvien.repository;

import com.vinorsoft.nhanvien.repository.base.BaseRepo;
import com.vinorsoft.nhanvien.repository.generate.tables.records.ChucVuRecord;

import java.util.List;
import java.util.Optional;

public interface ChucVuRepository extends BaseRepo {
    Optional<ChucVuRecord> findById(String id);

    <T> Optional<T> findById(String id, Class<T> returnType);

    boolean existsById(String id);

    boolean existsByTenChucVu(String tenChucVu);

    <T> List<T> getAllChucVu(Class<T> returnType);
}
