package com.vinorsoft.nhanvien.repository;

import com.vinorsoft.nhanvien.repository.base.BaseRepo;
import com.vinorsoft.nhanvien.repository.generate.tables.records.PhongBanRecord;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhongBanRepository extends BaseRepo {
    Optional<PhongBanRecord> findById(String id);

    boolean existsById(String id);

    boolean existsByTenPhongBan(String tenPhongBan);

}
