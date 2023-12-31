package com.vinorsoft.nhanvien.repository.base;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.util.List;
import java.util.Optional;

public interface BaseRepo {

    int save(Record record);

    int delete(Record record);

    int updateNotNull(Record record);

    <T> Optional<T> fetchOne(Table<?> table, Condition condition, Class<? extends T> type);

    <T> Optional<T> fetchOne(Table<?> table, Condition condition, Class<? extends T> type, Field<?>... fields);

    <T> Optional<T> fetchOne(Table<?> table, Condition condition, Class<? extends T> type, Field<?>[] mainFields, Field<?>... fields);

    boolean fetchExist(Table<?> table, Condition condition);

    <T> List<T> fetchAll(Table<?> table, Class<? extends T> type);
}
