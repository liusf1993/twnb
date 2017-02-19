package com.lsf.twnb.dao.plugins;


import com.lsf.twnb.common.dialect.IDialect;
import com.lsf.twnb.common.dialect.MySqlDialect;
import com.lsf.twnb.dao.base.PageQuery;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.TextSqlNode;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * mybatis 分页插件
 * 本插件拦截是Executor query(MappedStatement ms, Object parameter,
 * RowBounds rowBounds, ResultHandler resultHandler） 方法，
 * 根据查询条件重写参数rowBounds
 */
@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PagePlugin implements Interceptor {
    private final String DB_MYSQL = "mysql";
    private final String DB_ORCLE = "oracle";
    private String dbType = "mysql";
    private IDialect dialect = MySqlDialect.getInstance();
    private final TextSqlNode mysqlPageNode = new TextSqlNode(" limit #{offset},#{pageSize} ");

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //若查询参数不为分页参数，不作处理，按原计划执行
        if (!(invocation.getArgs()[1] instanceof PageQuery)) {
            return invocation.proceed();
        }
        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        List<SqlNode> textSqlNodes = (List<SqlNode>)
                SystemMetaObject.forObject(ms).getValue("sqlSource.rootSqlNode.contents");
        if (textSqlNodes.lastIndexOf(mysqlPageNode) != textSqlNodes.size() - 1) {
            textSqlNodes.add(mysqlPageNode);
        }

        PageQuery pageQuery = (PageQuery) invocation.getArgs()[1];
        BoundSql boundSql = ms.getBoundSql(pageQuery);
        //条件未继承分页查询类PageQuery的sql按原有逻辑处理
        if (!(boundSql.getParameterObject() instanceof PageQuery)) {
            return invocation.proceed();
        }
        Executor executor= (Executor) invocation.getTarget();
        Connection connection = executor.getTransaction().getConnection();
        //查询总条数会额外执行一条sql，影响性能
        if (pageQuery.isNeedTotalCount()) {
            //查询总条数
            int totalCount = getPageQueryCount(connection,ms,boundSql,pageQuery);
            pageQuery.setTotalCount(totalCount);
            if(totalCount==0){
                return Collections.EMPTY_LIST;
            }
        }

        return invocation.proceed();
    }

    /**
     * 查询数据总条数
     *
     * @param boundSql 绑定的sql
     * @param connection 数据库连接
     * @param pageQuery 分页查询参数
     * @param ms 匹配的语句
     * @return totalCount
     * @throws Throwable 异常
     */
    private int getPageQueryCount(Connection connection, MappedStatement ms, BoundSql boundSql, PageQuery pageQuery) throws Throwable {
        //获取绑定sql
        String sql = boundSql.getSql();
        //数据库连接
        //查询数据总条数
        PreparedStatement countQuery = connection.prepareStatement(
                dialect.generateCountSql(sql));
        //记录当前页数和每页条数（查询总条数时offset和limit要去掉）
        int pageSize= pageQuery.getPageSize();
        int pageNo= pageQuery.getPageNo();
        pageQuery.setPageNo(PageQuery.DEFAULT_PAGE_NO);
        pageQuery.setPageSize(RowBounds.NO_ROW_LIMIT);
        ParameterHandler parameterHandler = new DefaultParameterHandler(ms,
                pageQuery, boundSql);
        parameterHandler.setParameters(countQuery);
        ResultSet rs = countQuery.executeQuery();
        int totalCount = 0;
        try {
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
        } finally {
            rs.close();
            countQuery.close();
            pageQuery.setPageNo(pageNo);
            pageQuery.setPageSize(pageSize);
        }
        return totalCount;
    }



    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }


    @Override
    public void setProperties(Properties properties) {
    }

}
