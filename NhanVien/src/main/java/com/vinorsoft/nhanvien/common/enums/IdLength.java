package com.vinorsoft.nhanvien.common.enums;

import lombok.Getter;

@Getter
public enum IdLength {
    DEPARTMENT_ID(10),
    ROLE_ID(10),
    EMPLOYEE_ID(6),
    ;

    private final int length;

    IdLength(int length) {
        this.length = length;
    }
}
