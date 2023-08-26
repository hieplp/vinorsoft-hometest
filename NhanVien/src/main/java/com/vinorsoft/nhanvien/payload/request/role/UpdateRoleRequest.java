package com.vinorsoft.nhanvien.payload.request.role;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateRoleRequest {
    @NotBlank(message = "tenChucVu is mandatory")
    @Length(max = 100, message = "tenChucVu must be less than or equal to 100 characters")
    private String tenChucVu;

    @NotBlank(message = "thamQuyen is mandatory")
    @Length(max = 100, message = "thamQuyen must be less than or equal to 100 characters")
    private String thamQuyen;
}
