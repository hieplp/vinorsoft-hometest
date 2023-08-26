package com.vinorsoft.nhanvien.repository.base;

import org.jooq.DSLContext;

@FunctionalInterface
public interface TransactionHandler {
    void handle(DSLContext context);
}
