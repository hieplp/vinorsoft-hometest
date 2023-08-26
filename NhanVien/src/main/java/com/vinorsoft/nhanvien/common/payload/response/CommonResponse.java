package com.vinorsoft.nhanvien.common.payload.response;

import com.vinorsoft.nhanvien.common.enums.response.ResponseCode;
import lombok.Data;

import java.util.HashMap;

@Data
public class CommonResponse {
    protected String code;
    private Object data;
    private String message;

    public CommonResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = new HashMap<>();
    }

    public CommonResponse(ResponseCode response, Object data) {
        this.code = response.getCode();
        this.message = response.getMessage();
        this.data = data;
    }

    public CommonResponse(ResponseCode responseCode, String message) {
        this.code = responseCode.getCode();
        this.message = message;
        this.data = new HashMap<>();
    }
}
