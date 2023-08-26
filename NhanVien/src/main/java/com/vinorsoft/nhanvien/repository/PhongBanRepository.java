package com.vinorsoft.nhanvien.repository;

import com.vinorsoft.nhanvien.common.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, String> {
    boolean existsByTenPhongBan(String tenPhongBan);
}
