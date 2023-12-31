/*
 * This file is generated by jOOQ.
 */
package com.vinorsoft.nhanvien.repository.generate;


import com.vinorsoft.nhanvien.repository.generate.tables.ChucVu;
import com.vinorsoft.nhanvien.repository.generate.tables.PhongBan;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class NhanVien extends SchemaImpl {

    /**
     * The reference instance of <code>nhan_vien</code>
     */
    public static final NhanVien NHAN_VIEN = new NhanVien();
    private static final long serialVersionUID = 1L;
    /**
     * The table <code>nhan_vien.chuc_vu</code>.
     */
    public final ChucVu CHUC_VU = ChucVu.CHUC_VU;

    /**
     * The table <code>nhan_vien.nhan_vien</code>.
     */
    public final com.vinorsoft.nhanvien.repository.generate.tables.NhanVien NHAN_VIEN_ = com.vinorsoft.nhanvien.repository.generate.tables.NhanVien.NHAN_VIEN_;

    /**
     * The table <code>nhan_vien.phong_ban</code>.
     */
    public final PhongBan PHONG_BAN = PhongBan.PHONG_BAN;

    /**
     * No further instances allowed
     */
    private NhanVien() {
        super("nhan_vien", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
                ChucVu.CHUC_VU,
                com.vinorsoft.nhanvien.repository.generate.tables.NhanVien.NHAN_VIEN_,
                PhongBan.PHONG_BAN);
    }
}
