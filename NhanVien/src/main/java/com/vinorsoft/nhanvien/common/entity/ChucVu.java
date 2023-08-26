package com.vinorsoft.nhanvien.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChucVu {
    @Id
    private String chucVuId;
    @Column(unique = true, length = 100)
    private String tenChucVu;
    @Column(length = 100)
    private String thamQuyen;
}
