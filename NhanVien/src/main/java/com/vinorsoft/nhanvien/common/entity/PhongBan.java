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
public class PhongBan {
    @Id
    @Column(length = 10)
    private String phongBanId;
    @Column(unique = true, length = 100)
    private String tenPhongBan;
    @Column(length = 100)
    private String chucNang;
}
