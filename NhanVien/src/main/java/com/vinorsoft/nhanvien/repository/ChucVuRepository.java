package com.vinorsoft.nhanvien.repository;

import com.vinorsoft.nhanvien.common.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, String> {
    boolean existsByTenChucVu(String tenChucVu);
}
