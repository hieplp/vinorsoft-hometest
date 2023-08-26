package com.vinorsoft.nhanvien.payload.request.nhanvien;

import com.vinorsoft.nhanvien.common.payload.request.CommonGetRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetListOfNhanVienRequest extends CommonGetRequest {
    private String searchBy;
    private String searchValue;
    private String filterBy;
    private String filterValue;
}
