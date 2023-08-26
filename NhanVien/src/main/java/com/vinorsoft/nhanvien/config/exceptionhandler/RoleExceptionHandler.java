package com.vinorsoft.nhanvien.config.exceptionhandler;

import com.vinorsoft.nhanvien.common.enums.response.ErrorCode;
import com.vinorsoft.nhanvien.common.exception.role.DuplicatedRoleException;
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
public class RoleExceptionHandler {
    @ExceptionHandler(DuplicatedRoleException.class)
    public ResponseEntity<CommonResponse> handleDuplicatedDepartmentException(DuplicatedRoleException e) {
        log.error("DuplicatedRoleException: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new CommonResponse(ErrorCode.DUPLICATED_ROLE));
    }
}
