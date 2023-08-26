package com.vinorsoft.nhanvien.payload.request.nhanvien;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class UpdateNhanVienRequest {
    @NotBlank(message = "hoVaTen is mandatory")
    @Length(max = 100, message = "hoVaTen must be less than or equal to 100 characters")
    private String hoVaTen;

    @NotNull(message = "ngaySinh is mandatory")
    @Past(message = "The date of birth must be in the past.")
    private LocalDate ngaySinh;

    @NotBlank(message = "queQuan is mandatory")
    @Length(max = 100, message = "queQuan must be less than or equal to 100 characters")
    private String queQuan;

    @NotBlank(message = "sdt is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "sdt must be a valid phone number")
    private String sdt;

    @NotBlank(message = "email is mandatory")
    @Email(message = "email must be a valid email address")
    private String email;

    @NotBlank(message = "phongBanId is mandatory")
    private String phongBanId;

    @NotBlank(message = "chucVuId is mandatory")
    private String chucVuId;

    @NotNull(message = "luong is mandatory")
    private Long luong;

    private Byte trangThai;
}
