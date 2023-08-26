package com.vinorsoft.nhanvien.common.enums;

import lombok.Getter;

@Getter
public enum IdLength {
    DEPARTMENT_ID(10),
    ROLE_ID(10);

    private final int length;

    IdLength(int length) {
        this.length = length;
    }
}
