package com.vinorsoft.nhanvien.common.exception.nhanvien;


import com.vinorsoft.nhanvien.common.exception.BaseException;

public class DuplicatedEmailException extends BaseException {
    public DuplicatedEmailException(String message) {
        super(message);
    }
}
