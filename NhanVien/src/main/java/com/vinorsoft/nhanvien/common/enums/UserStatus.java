package com.vinorsoft.nhanvien.common.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    RETIRED(0),
    VACATION(1),
    ACTIVE(2),
    ;

    private final Byte status;

    UserStatus(Integer status) {
        this.status = status.byteValue();
    }

    public static void validate(Byte status) {
        if (status == null) {
            throw new IllegalArgumentException("Status is null");
        }
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.getStatus().equals(status)) {
                return;
            }
        }
        throw new IllegalArgumentException("Status is invalid");
    }
}
