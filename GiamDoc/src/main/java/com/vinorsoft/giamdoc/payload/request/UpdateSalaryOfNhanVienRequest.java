package com.vinorsoft.giamdoc.payload.request;

import lombok.Data;

import java.util.Map;

@Data
public class UpdateSalaryOfNhanVienRequest {
    Map<String, Long> salaries;
}
