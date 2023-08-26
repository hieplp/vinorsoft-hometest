package com.vinorsoft.nhanvien.common.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommonGetResponse<T> {
    private List<T> list;
    private Integer total;
}
