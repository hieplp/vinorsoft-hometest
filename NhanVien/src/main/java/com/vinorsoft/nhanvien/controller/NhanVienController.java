package com.vinorsoft.nhanvien.controller;

import com.vinorsoft.nhanvien.common.enums.response.SuccessCode;
import com.vinorsoft.nhanvien.common.payload.request.CommonGetRequest;
import com.vinorsoft.nhanvien.common.payload.response.CommonResponse;
import com.vinorsoft.nhanvien.payload.request.nhanvien.CreateNhanVienRequest;
import com.vinorsoft.nhanvien.payload.request.nhanvien.UpdateNhanVienRequest;
import com.vinorsoft.nhanvien.payload.request.nhanvien.UpdateSalaryOfNhanVienRequest;
import com.vinorsoft.nhanvien.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final static String MA_NHAN_VIEN_PATH = "/{maNhanVien}";

    private final NhanVienService nhanVienService;

    @PostMapping
    public ResponseEntity<CommonResponse> createNhanVien(@Valid @RequestBody CreateNhanVienRequest request) {
        log.info("Create nhanVien with request: {}", request);
        var data = nhanVienService.createNhanVien(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getListOfNhanVien(CommonGetRequest request) {
        log.info("Get list of nhanVien with request: {}", request);
        var data = nhanVienService.getListOfNhanVien(request);
//        var data = nhanVienService.getPagingListOfNhanVien(request);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @PutMapping(MA_NHAN_VIEN_PATH)
    public ResponseEntity<CommonResponse> updateNhanVien(@PathVariable String maNhanVien,
                                                         @Valid @RequestBody UpdateNhanVienRequest request) {
        log.info("Update nhanVien: {} with request: {}", maNhanVien, request);
        var data = nhanVienService.updateNhanVien(maNhanVien, request);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @GetMapping(MA_NHAN_VIEN_PATH)
    public ResponseEntity<CommonResponse> getNhanVien(@PathVariable String maNhanVien) {
        log.info("Get nhanVien: {}", maNhanVien);
        var data = nhanVienService.getNhanVien(maNhanVien);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @DeleteMapping(MA_NHAN_VIEN_PATH)
    public ResponseEntity<CommonResponse> deleteNhanVien(@PathVariable String maNhanVien) {
        log.info("Delete nhanVien: {}", maNhanVien);
        nhanVienService.deleteNhanVien(maNhanVien);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS));
    }

    @PutMapping("/update-salary")
    public ResponseEntity<CommonResponse> updateSalaryOfNhanVien(@Valid @RequestBody UpdateSalaryOfNhanVienRequest request) {
        log.info("Update salary of nhanVien with request: {}", request);
        nhanVienService.updateSalaryOfNhanVien(request.getSalaries());
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS));
    }
}
