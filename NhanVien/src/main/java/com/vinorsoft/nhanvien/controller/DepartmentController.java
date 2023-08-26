package com.vinorsoft.nhanvien.controller;

import com.vinorsoft.nhanvien.common.enums.response.SuccessCode;
import com.vinorsoft.nhanvien.common.payload.response.CommonResponse;
import com.vinorsoft.nhanvien.payload.request.department.CreateDepartmentRequest;
import com.vinorsoft.nhanvien.payload.request.department.UpdateDepartmentRequest;
import com.vinorsoft.nhanvien.service.DepartmentService;
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
public class DepartmentController {

    private final static String PHONG_BAN_ID_PATH = "/{phongBanId}";

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<CommonResponse> createDepartment(@Valid @RequestBody CreateDepartmentRequest request) {
        log.info("Create department with request: {}", request);
        var data = departmentService.createDepartment(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @PutMapping(PHONG_BAN_ID_PATH)
    public ResponseEntity<CommonResponse> updateDepartment(@PathVariable String phongBanId,
                                                           @Valid @RequestBody UpdateDepartmentRequest request) {
        log.info("Update department: {} with request: {}", phongBanId, request);
        var data = departmentService.updateDepartment(phongBanId, request);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @GetMapping(PHONG_BAN_ID_PATH)
    public ResponseEntity<CommonResponse> getDepartment(@PathVariable String phongBanId) {
        log.info("Get department: {}", phongBanId);
        var data = departmentService.getDepartment(phongBanId);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS, data));
    }

    @DeleteMapping(PHONG_BAN_ID_PATH)
    public ResponseEntity<CommonResponse> deleteDepartment(@PathVariable String phongBanId) {
        log.info("Delete department: {}", phongBanId);
        departmentService.deleteDepartment(phongBanId);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS));
    }
}
