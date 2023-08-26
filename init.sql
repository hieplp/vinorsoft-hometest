create schema nhan_vien;
create table if not exists nhan_vien.chuc_vu
(
    chuc_vu_id  varchar(255) not null
        primary key,
    ten_chuc_vu varchar(100) null,
    tham_quyen  varchar(100) null,
    constraint UK_8ny3m1supv5k5s1sxvhhho88f
        unique (ten_chuc_vu)
);

create table if not exists nhan_vien.nhan_vien
(
    id           int auto_increment
        primary key,
    chuc_vu_id   varchar(10)  null,
    email        varchar(100) null,
    ho_va_ten    varchar(100) null,
    luong        bigint       not null,
    ma_nhan_vien varchar(6)   null,
    ngay_sinh    date         null,
    phong_ban_id varchar(10)  null,
    que_quan     varchar(100) null,
    sdt          varchar(10)  null,
    trang_thai   tinyint      not null,
    constraint UK_12waxxsiniyddv2lt9ianfh8a
        unique (email),
    constraint UK_f0qentjxcfeoyrwxpv5htu514
        unique (ma_nhan_vien),
    constraint UK_mafuwxhl2bcv6obb9fkouokec
        unique (sdt)
);

create table if not exists nhan_vien.phong_ban
(
    phong_ban_id  varchar(10)  not null
        primary key,
    chuc_nang     varchar(100) null,
    ten_phong_ban varchar(100) null,
    constraint UK_87reome3qodvjnx84f1ojif94
        unique (ten_phong_ban)
);

