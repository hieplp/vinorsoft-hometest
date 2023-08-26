package com.vinorsoft.nhanvien.repository.base;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;

import java.util.Optional;

public interface BaseRepo {

    int save(Record record);

    /**
     * Delete record from database
     *
     * @param record record to delete
     */
    int delete(Record record);

    int updateNotNull(Record record);

    /**
     * Execute transaction
     *
     * @param handler transaction handler
     */
    void transaction(TransactionHandler handler);

    <R extends Record> R fetchOneNotNull(Table<R> table, Condition condition);

    <T> T fetchOneNotNull(Table<?> table, Condition condition, Class<? extends T> type);

    <T> Optional<T> fetchOne(Table<?> table, Condition condition, Class<? extends T> type);


    <T> Optional<T> fetchOne(Table<?> table, Condition condition, Class<? extends T> type, Field<?>... fields);

    boolean fetchExist(Table<?> table, Condition condition);
}
