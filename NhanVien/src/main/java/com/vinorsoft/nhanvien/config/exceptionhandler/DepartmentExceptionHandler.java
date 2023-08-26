package com.vinorsoft.nhanvien.config.exceptionhandler;

import com.vinorsoft.nhanvien.common.enums.response.ErrorCode;
import com.vinorsoft.nhanvien.common.exception.department.DuplicatedDepartmentException;
import com.vinorsoft.nhanvien.common.payload.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DepartmentExceptionHandler {
    @ExceptionHandler(DuplicatedDepartmentException.class)
    public ResponseEntity<CommonResponse> handleDuplicatedDepartmentException(DuplicatedDepartmentException e) {
        log.error("DuplicatedDepartmentException: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new CommonResponse(ErrorCode.DUPLICATED_DEPARTMENT));
    }
}
