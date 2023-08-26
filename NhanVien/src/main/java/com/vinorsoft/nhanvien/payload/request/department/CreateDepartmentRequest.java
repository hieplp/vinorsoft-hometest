package com.vinorsoft.nhanvien.payload.request.department;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@Data
public class CreateDepartmentRequest {
    @NotBlank(message = "tenPhongBan is mandatory")
    @Length(max = 100, message = "tenPhongBan must be less than or equal to 100 characters")
    private String tenPhongBan;

    @NotBlank(message = "chucNang is mandatory")
    @Length(max = 100, message = "chucNang must be less than or equal to 100 characters")
    private String chucNang;
}
