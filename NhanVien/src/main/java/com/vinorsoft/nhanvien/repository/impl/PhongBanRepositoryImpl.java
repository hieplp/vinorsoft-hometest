package com.vinorsoft.nhanvien.repository.impl;

import com.vinorsoft.nhanvien.repository.PhongBanRepository;
import com.vinorsoft.nhanvien.repository.base.BaseRepoImpl;
import com.vinorsoft.nhanvien.repository.generate.tables.records.PhongBanRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.vinorsoft.nhanvien.repository.generate.Tables.PHONG_BAN;

@Slf4j
@Repository
public class PhongBanRepositoryImpl extends BaseRepoImpl implements PhongBanRepository {
    public PhongBanRepositoryImpl(DSLContext context) {
        super(context);
    }

    @Override
    public Optional<PhongBanRecord> findById(String id) {
        log.info("Find phongBan by id: {}", id);
        return fetchOne(PHONG_BAN, PHONG_BAN.PHONG_BAN_ID.eq(id), PhongBanRecord.class);
    }

    @Override
    public <T> Optional<T> findById(String id, Class<T> returnType) {
        log.info("Find phongBan by id: {}", id);
        return fetchOne(PHONG_BAN, PHONG_BAN.PHONG_BAN_ID.eq(id), returnType);
    }

    @Override
    public boolean existsById(String id) {
        log.info("Check exist phongBan by id: {}", id);
        return fetchExist(PHONG_BAN, PHONG_BAN.PHONG_BAN_ID.eq(id));
    }

    @Override
    public boolean existsByTenPhongBan(String tenPhongBan) {
        log.info("Check exist phongBan by tenPhongBan: {}", tenPhongBan);
        return fetchExist(PHONG_BAN, PHONG_BAN.TEN_PHONG_BAN.eq(tenPhongBan));
    }

    @Override
    public <T> List<T> getAllPhongBan(Class<T> returnType) {
        log.info("Get all phongBan");
        return fetchAll(PHONG_BAN, returnType);
    }
}
