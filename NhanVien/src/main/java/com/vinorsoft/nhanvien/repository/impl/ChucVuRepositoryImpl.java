package com.vinorsoft.nhanvien.repository.impl;


import com.vinorsoft.nhanvien.repository.ChucVuRepository;
import com.vinorsoft.nhanvien.repository.base.BaseRepoImpl;
import com.vinorsoft.nhanvien.repository.generate.tables.records.ChucVuRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.vinorsoft.nhanvien.repository.generate.Tables.CHUC_VU;

@Slf4j
@Repository
public class ChucVuRepositoryImpl extends BaseRepoImpl implements ChucVuRepository {

    public ChucVuRepositoryImpl(DSLContext context) {
        super(context);
    }

    @Override
    public Optional<ChucVuRecord> findById(String id) {
        log.info("Find chucVu by id: {}", id);
        return fetchOne(CHUC_VU, CHUC_VU.CHUC_VU_ID.eq(id), ChucVuRecord.class);
    }

    @Override
    public boolean existsById(String id) {
        log.info("Check exist chucVu by id: {}", id);
        return fetchExist(CHUC_VU, CHUC_VU.CHUC_VU_ID.eq(id));
    }

    @Override
    public boolean existsByTenChucVu(String tenChucVu) {
        log.info("Check exist chucVu by tenChucVu: {}", tenChucVu);
        return fetchExist(CHUC_VU, CHUC_VU.TEN_CHUC_VU.eq(tenChucVu));
    }
}
