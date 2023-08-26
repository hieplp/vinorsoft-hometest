package com.vinorsoft.nhanvien.config.exceptionhandler;


import com.vinorsoft.nhanvien.common.enums.response.ErrorCode;
import com.vinorsoft.nhanvien.common.exception.NotFoundException;
import com.vinorsoft.nhanvien.common.payload.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order()
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CommonResponse> handleNotFoundException(NotFoundException e) {
        log.error("NotFoundException: {}", e.getMessage());
        return new ResponseEntity<>(new CommonResponse(ErrorCode.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleException(Exception e) {
        log.error("Exception: ", e);
        return ResponseEntity
                .internalServerError()
                .body(new CommonResponse(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}
