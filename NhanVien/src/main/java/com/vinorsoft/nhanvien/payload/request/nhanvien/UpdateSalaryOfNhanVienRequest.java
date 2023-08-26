package com.vinorsoft.nhanvien.payload.request.nhanvien;

import lombok.Data;

import java.util.Map;

@Data
public class UpdateSalaryOfNhanVienRequest {
    Map<String, Long> salaries;
}
