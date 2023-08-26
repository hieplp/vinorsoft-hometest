package com.vinorsoft.nhanvien.repository;

import com.vinorsoft.nhanvien.repository.base.BaseRepo;
import com.vinorsoft.nhanvien.repository.generate.tables.records.PhongBanRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhongBanRepository extends BaseRepo {
    Optional<PhongBanRecord> findById(String id);

    <T> Optional<T> findById(String id, Class<T> returnType);

    boolean existsById(String id);

    boolean existsByTenPhongBan(String tenPhongBan);

    <T> List<T> getAllPhongBan(Class<T> returnType);
}
