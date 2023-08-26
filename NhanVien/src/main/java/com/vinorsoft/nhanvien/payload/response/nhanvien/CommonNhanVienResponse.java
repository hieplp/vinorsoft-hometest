package com.vinorsoft.nhanvien.payload.response.nhanvien;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonNhanVienResponse {
    private int id;
    private String maNhanVien;
    private String hoVaTen;
    private Date ngaySinh;
    private String queQuan;
    private String sdt;
    private String email;
    private String phongBanId;
    private String tenPhongBan;
    private String chucVuId;
    private String tenChucVu;
    private long luong;
    private byte trangThai;
}
