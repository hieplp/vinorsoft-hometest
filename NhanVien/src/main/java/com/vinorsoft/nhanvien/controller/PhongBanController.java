package com.vinorsoft.nhanvien.controller;

import com.vinorsoft.nhanvien.common.enums.response.SuccessCode;
import com.vinorsoft.nhanvien.common.payload.response.CommonResponse;
import com.vinorsoft.nhanvien.payload.request.phongban.CreatePhongBanRequest;
import com.vinorsoft.nhanvien.payload.request.phongban.UpdatePhongBanRequest;
import com.vinorsoft.nhanvien.service.PhongBanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("phong-ban")
public class PhongBanController {

    private final static String PHONG_BAN_ID_PATH = "/{phongBanId}";

    private final PhongBanService phongBanService;

    @PostMapping
    public ResponseEntity<CommonResponse> createDepartment(@Valid @RequestBody CreatePhongBanRequest request) {
        log.info("Create phongBan with request: {}", request);
        var data = phongBanService.createPhongBan(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllDepartment() {
        log.info("Get all phongBan");
        var data = phongBanService.getAllPhongBan();
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @PutMapping(PHONG_BAN_ID_PATH)
    public ResponseEntity<CommonResponse> updateDepartment(@PathVariable String phongBanId,
                                                           @Valid @RequestBody UpdatePhongBanRequest request) {
        log.info("Update phongBan: {} with request: {}", phongBanId, request);
        var data = phongBanService.updatePhongBan(phongBanId, request);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @GetMapping(PHONG_BAN_ID_PATH)
    public ResponseEntity<CommonResponse> getDepartment(@PathVariable String phongBanId) {
        log.info("Get phongBan: {}", phongBanId);
        var data = phongBanService.getPhongBan(phongBanId);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @DeleteMapping(PHONG_BAN_ID_PATH)
    public ResponseEntity<CommonResponse> deleteDepartment(@PathVariable String phongBanId) {
        log.info("Delete phongBan: {}", phongBanId);
        phongBanService.deletePhongBan(phongBanId);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS));
    }
}
