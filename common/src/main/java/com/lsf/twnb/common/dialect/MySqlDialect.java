package com.lsf.twnb.common.dialect;

/**
 * MySql Dialect
 */
public class MySqlDialect implements IDialect {
    private static IDialect dialect;
    public static   IDialect getInstance() {
        if(dialect==null){
            dialect= new MySqlDialect();
        }
        return dialect;
    }

    @Override
    public String generatePageSql(String sql) {
        StringBuilder pageSqlBuilder=new StringBuilder(sql);
        pageSqlBuilder.append(" limit ?,?");
        return pageSqlBuilder.toString();
    }
}
