package com.vinorsoft.nhanvien.repository.impl;

import com.vinorsoft.nhanvien.common.payload.request.CommonGetRequest;
import com.vinorsoft.nhanvien.common.payload.response.CommonGetResponse;
import com.vinorsoft.nhanvien.repository.NhanVienRepository;
import com.vinorsoft.nhanvien.repository.base.BaseRepoImpl;
import com.vinorsoft.nhanvien.repository.generate.tables.records.NhanVienRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.vinorsoft.nhanvien.repository.generate.Tables.*;


@Slf4j
@Repository
public class NhanVienRepositoryImpl extends BaseRepoImpl implements NhanVienRepository {

    private final static Map<String, TableField> filterMap = Map.of(
            "phongBanId", NHAN_VIEN_.PHONG_BAN_ID,
            "chucVuId", NHAN_VIEN_.CHUC_VU_ID,
            "trangThai", NHAN_VIEN_.TRANG_THAI
    );

    private final static Map<String, TableField> searchMap = Map.of(
            "hoVaTen", NHAN_VIEN_.HO_VA_TEN,
            "queQuan", NHAN_VIEN_.QUE_QUAN,
            "tenPhongBan", PHONG_BAN.TEN_PHONG_BAN,
            "tenChucVu", CHUC_VU.TEN_CHUC_VU
    );

    public NhanVienRepositoryImpl(DSLContext context) {
        super(context);
    }

    @Override
    public boolean existsByEmail(String email) {
        log.info("Check exist nhanVien by email: {}", email);
        return fetchExist(NHAN_VIEN_, NHAN_VIEN_.EMAIL.eq(email));
    }

    @Override
    public boolean existsBySdt(String sdt) {
        log.info("Check exist nhanVien by sdt: {}", sdt);
        return fetchExist(NHAN_VIEN_, NHAN_VIEN_.SDT.eq(sdt));
    }

    @Override
    public Optional<NhanVienRecord> findByMaNhanVien(String maNhanVien) {
        log.info("Find nhanVien by maNhanVien: {}", maNhanVien);
        return fetchOne(NHAN_VIEN_, NHAN_VIEN_.MA_NHAN_VIEN.eq(maNhanVien), NhanVienRecord.class);
    }

    @Override
    public int countNhanVienByPhongBanId(String phongBanId) {
        log.info("Count nhanVien by phongBanId: {}", phongBanId);
        return Objects.requireNonNull(context.selectCount()
                        .from(NHAN_VIEN_)
                        .where(NHAN_VIEN_.PHONG_BAN_ID.eq(phongBanId))
                        .fetchOne())
                .into(int.class);
    }

    @Override
    public int countNhanVienByChucVuId(String chucVuId) {
        log.info("Count nhanVien by chucVuId: {}", chucVuId);
        return Objects.requireNonNull(context.selectCount()
                        .from(NHAN_VIEN_)
                        .where(NHAN_VIEN_.CHUC_VU_ID.eq(chucVuId))
                        .fetchOne())
                .into(int.class);
    }

    @Override
    public <T> List<T> getListOfNhanVien(CommonGetRequest request, Class<T> returnType) {
        log.info("Get list of nhanVien with request: {}", request);
        var condition = getGetListOfNhanVienCondition(request);
        return context
                .select(NHAN_VIEN_.fields())
                .select(PHONG_BAN.TEN_PHONG_BAN, CHUC_VU.TEN_CHUC_VU)
                .from(NHAN_VIEN_
                        .join(PHONG_BAN).on(NHAN_VIEN_.PHONG_BAN_ID.eq(PHONG_BAN.PHONG_BAN_ID))
                        .join(CHUC_VU).on(NHAN_VIEN_.CHUC_VU_ID.eq(CHUC_VU.CHUC_VU_ID)))
                .where(condition)
                .fetchInto(returnType);
    }

    @Override
    public <T> CommonGetResponse<T> getPagingListOfNhanVien(CommonGetRequest request, Class<T> returnType) {
        log.info("Get paging list of nhanVien with request: {}", request);
        var condition = getGetListOfNhanVienCondition(request);
        var table = NHAN_VIEN_
                .join(PHONG_BAN).on(NHAN_VIEN_.PHONG_BAN_ID.eq(PHONG_BAN.PHONG_BAN_ID))
                .join(CHUC_VU).on(NHAN_VIEN_.CHUC_VU_ID.eq(CHUC_VU.CHUC_VU_ID));
        return CommonGetResponse.<T>builder()
                .list(context
                        .select(NHAN_VIEN_.fields())
                        .select(PHONG_BAN.TEN_PHONG_BAN, CHUC_VU.TEN_CHUC_VU)
                        .from(table)
                        .where(condition)
                        .offset(request.getPage() * request.getSize())
                        .limit(request.getSize())
                        .fetchInto(returnType))
                .total(context.selectCount()
                        .from(table)
                        .where(condition)
                        .fetchOneInto(int.class))
                .build();
    }

    private Condition getGetListOfNhanVienCondition(CommonGetRequest request) {
        var condition = DSL.noCondition();
        if (request.getFilterBy() != null && filterMap.containsKey(request.getFilterBy())) {
            log.debug("Filter by: {} and value: {}", request.getFilterBy(), request.getFilterValue());
            var filterField = filterMap.get(request.getFilterBy());
            var fieldValue = filterField.getDataType().convert(request.getFilterValue());
            condition = condition.and(filterField.eq(fieldValue));
        }

        if (request.getSearchBy() != null && searchMap.containsKey(request.getSearchBy())) {
            log.debug("Search by: {} and value: {}", request.getSearchBy(), request.getSearchValue());
            var searchField = searchMap.get(request.getSearchBy());
            var searchValue = searchField.getDataType().convert(request.getSearchValue());
            condition = condition.and(searchField.contains(searchValue));
        }

        return condition;
    }
}
