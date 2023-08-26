/*
 * This file is generated by jOOQ.
 */
package com.vinorsoft.nhanvien.repository.generate.tables.daos;


import com.vinorsoft.nhanvien.repository.generate.tables.PhongBan;
import com.vinorsoft.nhanvien.repository.generate.tables.records.PhongBanRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class PhongBanDao extends DAOImpl<PhongBanRecord, com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan, String> {

    /**
     * Create a new PhongBanDao without any configuration
     */
    public PhongBanDao() {
        super(PhongBan.PHONG_BAN, com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan.class);
    }

    /**
     * Create a new PhongBanDao with an attached configuration
     */
    public PhongBanDao(Configuration configuration) {
        super(PhongBan.PHONG_BAN, com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan.class, configuration);
    }

    @Override
    public String getId(com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan object) {
        return object.getPhongBanId();
    }

    /**
     * Fetch records that have <code>phong_ban_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan> fetchRangeOfPhongBanId(String lowerInclusive, String upperInclusive) {
        return fetchRange(PhongBan.PHONG_BAN.PHONG_BAN_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>phong_ban_id IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan> fetchByPhongBanId(String... values) {
        return fetch(PhongBan.PHONG_BAN.PHONG_BAN_ID, values);
    }

    /**
     * Fetch a unique record that has <code>phong_ban_id = value</code>
     */
    public com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan fetchOneByPhongBanId(String value) {
        return fetchOne(PhongBan.PHONG_BAN.PHONG_BAN_ID, value);
    }

    /**
     * Fetch records that have <code>chuc_nang BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan> fetchRangeOfChucNang(String lowerInclusive, String upperInclusive) {
        return fetchRange(PhongBan.PHONG_BAN.CHUC_NANG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>chuc_nang IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan> fetchByChucNang(String... values) {
        return fetch(PhongBan.PHONG_BAN.CHUC_NANG, values);
    }

    /**
     * Fetch records that have <code>ten_phong_ban BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan> fetchRangeOfTenPhongBan(String lowerInclusive, String upperInclusive) {
        return fetchRange(PhongBan.PHONG_BAN.TEN_PHONG_BAN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ten_phong_ban IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan> fetchByTenPhongBan(String... values) {
        return fetch(PhongBan.PHONG_BAN.TEN_PHONG_BAN, values);
    }

    /**
     * Fetch a unique record that has <code>ten_phong_ban = value</code>
     */
    public com.vinorsoft.nhanvien.repository.generate.tables.pojos.PhongBan fetchOneByTenPhongBan(String value) {
        return fetchOne(PhongBan.PHONG_BAN.TEN_PHONG_BAN, value);
    }
}
