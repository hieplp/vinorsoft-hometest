package com.vinorsoft.nhanvien.controller;

import com.vinorsoft.nhanvien.common.enums.response.SuccessCode;
import com.vinorsoft.nhanvien.common.payload.response.CommonResponse;
import com.vinorsoft.nhanvien.payload.request.chucvu.CreateChucVuRequest;
import com.vinorsoft.nhanvien.payload.request.chucvu.UpdateChucVuRequest;
import com.vinorsoft.nhanvien.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/chuc-vu")
@RequiredArgsConstructor
public class ChucVuController {
    private final static String CHUC_VU_ID_PATH = "/{chucVuId}";

    private final ChucVuService chucVuService;

    @PostMapping
    public ResponseEntity<CommonResponse> createChucVu(@Valid @RequestBody CreateChucVuRequest request) {
        log.info("Create chucVu with request: {}", request);
        var data = chucVuService.createChucVu(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllChucVu() {
        log.info("Get all chucVu");
        var data = chucVuService.getAllChucVu();
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @PutMapping(CHUC_VU_ID_PATH)
    public ResponseEntity<CommonResponse> updateChucVu(@PathVariable String chucVuId,
                                                       @Valid @RequestBody UpdateChucVuRequest request) {
        log.info("Update chucVu: {} with request: {}", chucVuId, request);
        var data = chucVuService.updateChucVu(chucVuId, request);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @GetMapping(CHUC_VU_ID_PATH)
    public ResponseEntity<CommonResponse> getChucVu(@PathVariable String chucVuId) {
        log.info("Get chucVu: {}", chucVuId);
        var data = chucVuService.getChucVu(chucVuId);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @DeleteMapping(CHUC_VU_ID_PATH)
    public ResponseEntity<CommonResponse> deleteChucVu(@PathVariable String chucVuId) {
        log.info("Delete chucVu: {}", chucVuId);
        chucVuService.deleteChucVu(chucVuId);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS));
    }
}
