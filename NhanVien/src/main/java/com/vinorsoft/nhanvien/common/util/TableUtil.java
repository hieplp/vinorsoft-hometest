package com.vinorsoft.nhanvien.common.util;

import org.jooq.*;
import org.jooq.impl.DSL;

public class TableUtil {

    public static Table<?> getTable(Record record) {
        return ((TableRecord<?>) record).getTable();
    }


    public static Condition equalKey(Table<?> table, Record record) {
        var condition = DSL.noCondition();
        if (table.getPrimaryKey() == null) {
            return condition;
        }

        for (TableField field : table.getPrimaryKey().getFields()) {
            var fieldValue = field.getDataType().convert(record.getValue(field.getName()));
            condition = condition.and(field.eq(fieldValue));
        }

        return condition;
    }
}
