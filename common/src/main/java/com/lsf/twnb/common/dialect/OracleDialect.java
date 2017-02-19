package com.lsf.twnb.common.dialect;

/**
 * Oracle Dialect
 */
public class OracleDialect implements IDialect {
    private static IDialect dialect;
    public static IDialect getInstance() {
        if(dialect==null){
            dialect= new OracleDialect();
        }
        return dialect;
    }

    @Override
    public String generatePageSql(String sql) {
        StringBuilder pageSqlBuilder=new StringBuilder(sql);
        pageSqlBuilder.insert(0,"select upperBounds.*,rowNum row from ( ");
        pageSqlBuilder.append(" ) upperBounds where rownum<? ");

        pageSqlBuilder.insert(0,"select lowerBounds.* from (");
        pageSqlBuilder.append(" ) lowerBounds where row>? ");
        return pageSqlBuilder.toString();
    }
}
