/*
 * This file is generated by jOOQ.
 */
package com.vinorsoft.nhanvien.repository.generate;


import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class DefaultCatalog extends CatalogImpl {

    /**
     * The reference instance of <code>DEFAULT_CATALOG</code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();
    private static final long serialVersionUID = 1L;
    /**
     * The schema <code>nhan_vien</code>.
     */
    public final NhanVien NHAN_VIEN = NhanVien.NHAN_VIEN;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        return Arrays.<Schema>asList(
                NhanVien.NHAN_VIEN);
    }
}
