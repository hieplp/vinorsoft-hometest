package com.vinorsoft.nhanvien.common.payload.request;

import lombok.Data;

@Data
public class CommonGetRequest {
    private String searchBy;
    private String searchValue;
    private String filterBy;
    private String filterValue;
    private int page;
    private int size;
}
