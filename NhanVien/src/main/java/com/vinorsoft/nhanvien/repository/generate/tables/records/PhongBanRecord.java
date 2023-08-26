/*
 * This file is generated by jOOQ.
 */
package com.vinorsoft.nhanvien.repository.generate.tables.records;


import com.vinorsoft.nhanvien.repository.generate.tables.PhongBan;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class PhongBanRecord extends UpdatableRecordImpl<PhongBanRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Create a detached PhongBanRecord
     */
    public PhongBanRecord() {
        super(PhongBan.PHONG_BAN);
    }

    /**
     * Create a detached, initialised PhongBanRecord
     */
    public PhongBanRecord(String phongBanId, String chucNang, String tenPhongBan) {
        super(PhongBan.PHONG_BAN);

        setPhongBanId(phongBanId);
        setChucNang(chucNang);
        setTenPhongBan(tenPhongBan);
    }

    /**
     * Getter for <code>nhan_vien.phong_ban.phong_ban_id</code>.
     */
    public String getPhongBanId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>nhan_vien.phong_ban.phong_ban_id</code>.
     */
    public PhongBanRecord setPhongBanId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>nhan_vien.phong_ban.chuc_nang</code>.
     */
    public String getChucNang() {
        return (String) get(1);
    }

    /**
     * Setter for <code>nhan_vien.phong_ban.chuc_nang</code>.
     */
    public PhongBanRecord setChucNang(String value) {
        set(1, value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>nhan_vien.phong_ban.ten_phong_ban</code>.
     */
    public String getTenPhongBan() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>nhan_vien.phong_ban.ten_phong_ban</code>.
     */
    public PhongBanRecord setTenPhongBan(String value) {
        set(2, value);
        return this;
    }

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return PhongBan.PHONG_BAN.PHONG_BAN_ID;
    }

    @Override
    public Field<String> field2() {
        return PhongBan.PHONG_BAN.CHUC_NANG;
    }

    @Override
    public Field<String> field3() {
        return PhongBan.PHONG_BAN.TEN_PHONG_BAN;
    }

    @Override
    public String component1() {
        return getPhongBanId();
    }

    @Override
    public String component2() {
        return getChucNang();
    }

    @Override
    public String component3() {
        return getTenPhongBan();
    }

    @Override
    public String value1() {
        return getPhongBanId();
    }

    @Override
    public String value2() {
        return getChucNang();
    }

    @Override
    public String value3() {
        return getTenPhongBan();
    }

    @Override
    public PhongBanRecord value1(String value) {
        setPhongBanId(value);
        return this;
    }

    @Override
    public PhongBanRecord value2(String value) {
        setChucNang(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    @Override
    public PhongBanRecord value3(String value) {
        setTenPhongBan(value);
        return this;
    }

    @Override
    public PhongBanRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }
}