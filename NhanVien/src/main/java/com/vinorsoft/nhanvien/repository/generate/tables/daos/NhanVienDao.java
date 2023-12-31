/*
 * This file is generated by jOOQ.
 */
package com.vinorsoft.nhanvien.repository.generate.tables.daos;


import com.vinorsoft.nhanvien.repository.generate.tables.NhanVien;
import com.vinorsoft.nhanvien.repository.generate.tables.records.NhanVienRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import java.time.LocalDate;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class NhanVienDao extends DAOImpl<NhanVienRecord, com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien, Integer> {

    /**
     * Create a new NhanVienDao without any configuration
     */
    public NhanVienDao() {
        super(NhanVien.NHAN_VIEN_, com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien.class);
    }

    /**
     * Create a new NhanVienDao with an attached configuration
     */
    public NhanVienDao(Configuration configuration) {
        super(NhanVien.NHAN_VIEN_, com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien.class, configuration);
    }

    @Override
    public Integer getId(com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchById(Integer... values) {
        return fetch(NhanVien.NHAN_VIEN_.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien fetchOneById(Integer value) {
        return fetchOne(NhanVien.NHAN_VIEN_.ID, value);
    }

    /**
     * Fetch records that have <code>chuc_vu_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfChucVuId(String lowerInclusive, String upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.CHUC_VU_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>chuc_vu_id IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByChucVuId(String... values) {
        return fetch(NhanVien.NHAN_VIEN_.CHUC_VU_ID, values);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByEmail(String... values) {
        return fetch(NhanVien.NHAN_VIEN_.EMAIL, values);
    }

    /**
     * Fetch a unique record that has <code>email = value</code>
     */
    public com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien fetchOneByEmail(String value) {
        return fetchOne(NhanVien.NHAN_VIEN_.EMAIL, value);
    }

    /**
     * Fetch records that have <code>ho_va_ten BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfHoVaTen(String lowerInclusive, String upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.HO_VA_TEN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ho_va_ten IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByHoVaTen(String... values) {
        return fetch(NhanVien.NHAN_VIEN_.HO_VA_TEN, values);
    }

    /**
     * Fetch records that have <code>luong BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfLuong(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.LUONG, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>luong IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByLuong(Long... values) {
        return fetch(NhanVien.NHAN_VIEN_.LUONG, values);
    }

    /**
     * Fetch records that have <code>ma_nhan_vien BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfMaNhanVien(String lowerInclusive, String upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.MA_NHAN_VIEN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ma_nhan_vien IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByMaNhanVien(String... values) {
        return fetch(NhanVien.NHAN_VIEN_.MA_NHAN_VIEN, values);
    }

    /**
     * Fetch a unique record that has <code>ma_nhan_vien = value</code>
     */
    public com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien fetchOneByMaNhanVien(String value) {
        return fetchOne(NhanVien.NHAN_VIEN_.MA_NHAN_VIEN, value);
    }

    /**
     * Fetch records that have <code>ngay_sinh BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfNgaySinh(LocalDate lowerInclusive, LocalDate upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.NGAY_SINH, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ngay_sinh IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByNgaySinh(LocalDate... values) {
        return fetch(NhanVien.NHAN_VIEN_.NGAY_SINH, values);
    }

    /**
     * Fetch records that have <code>phong_ban_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfPhongBanId(String lowerInclusive, String upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.PHONG_BAN_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>phong_ban_id IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByPhongBanId(String... values) {
        return fetch(NhanVien.NHAN_VIEN_.PHONG_BAN_ID, values);
    }

    /**
     * Fetch records that have <code>que_quan BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfQueQuan(String lowerInclusive, String upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.QUE_QUAN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>que_quan IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByQueQuan(String... values) {
        return fetch(NhanVien.NHAN_VIEN_.QUE_QUAN, values);
    }

    /**
     * Fetch records that have <code>sdt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfSdt(String lowerInclusive, String upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.SDT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sdt IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchBySdt(String... values) {
        return fetch(NhanVien.NHAN_VIEN_.SDT, values);
    }

    /**
     * Fetch a unique record that has <code>sdt = value</code>
     */
    public com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien fetchOneBySdt(String value) {
        return fetchOne(NhanVien.NHAN_VIEN_.SDT, value);
    }

    /**
     * Fetch records that have <code>trang_thai BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchRangeOfTrangThai(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(NhanVien.NHAN_VIEN_.TRANG_THAI, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>trang_thai IN (values)</code>
     */
    public List<com.vinorsoft.nhanvien.repository.generate.tables.pojos.NhanVien> fetchByTrangThai(Byte... values) {
        return fetch(NhanVien.NHAN_VIEN_.TRANG_THAI, values);
    }
}
