package com.lsf.twnb.common.dialect;

/**
 * DB Dialect
 */
public interface IDialect {
    default   String generateCountSql(String sql){
        StringBuilder countSqlBuilder= new StringBuilder(sql);
        countSqlBuilder.insert(0, "select count(1) from (");
        countSqlBuilder.append(" ) countQuery");

        return countSqlBuilder.toString();
    }
    String generatePageSql(String sql);

}
