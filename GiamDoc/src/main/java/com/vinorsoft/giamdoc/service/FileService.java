package com.vinorsoft.giamdoc.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void store(MultipartFile file);

    void updateSalaryByMonth();
}
