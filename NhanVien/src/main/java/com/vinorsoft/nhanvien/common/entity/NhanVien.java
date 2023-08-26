package com.vinorsoft.nhanvien.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, length = 6)
    private String maNhanVien;

    @Column(length = 100)
    private String hoVaTen;

    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(length = 100)
    private String queQuan;

    @Column(unique = true, length = 10)
    private String sdt;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 10)
    private String phongBanId;

    @Column(length = 10)
    private String chucVuId;

    private double luong;

    private byte trangThai;
}
