package com.vinorsoft.giamdoc.controller;

import com.vinorsoft.giamdoc.common.enums.response.SuccessCode;
import com.vinorsoft.giamdoc.common.payload.response.CommonResponse;
import com.vinorsoft.giamdoc.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/giam-doc")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<CommonResponse> handleFileUpload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return ResponseEntity.ok(new CommonResponse(SuccessCode.SUCCESS));
    }
}
