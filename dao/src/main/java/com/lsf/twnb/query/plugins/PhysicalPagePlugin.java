package com.lsf.twnb.query.plugins;

import com.lsf.twnb.Exception.ConfigurationException;
import com.lsf.twnb.common.dialect.IDialect;
import com.lsf.twnb.common.dialect.MySqlDialect;
import com.lsf.twnb.common.dialect.OracleDialect;
import com.lsf.twnb.query.base.PageQuery;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * 基于mybatis的物理分页
 */
@Intercepts(@Signature(type = StatementHandler.class,method = "prepare",args = {
        Connection.class

}))
public class PhysicalPagePlugin implements Interceptor {
    private  final String DB_MYSQL="mysql";
    private  final String DB_ORCLE="oracle";
    private String dbType="mysql";
    private IDialect dialect =MySqlDialect.getInstance();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if(invocation.getTarget() instanceof RoutingStatementHandler){
            RoutingStatementHandler rsh= (RoutingStatementHandler) invocation.getTarget();
            BoundSql boundSql=rsh.getBoundSql();
            //条件未继承分页查询类PageQuery的sql按原有逻辑处理
            if(!(boundSql.getParameterObject() instanceof PageQuery)){
                return invocation.proceed();
            }
            PageQuery pageQuery= (PageQuery) boundSql.getParameterObject();
            Connection connection= (Connection) invocation.getArgs()[0];
            MetaObject metaObject=SystemMetaObject.forObject(rsh);
            //查询总条数会额外执行一条sql，影响性能
            if(pageQuery.isNeedTotalCount()) {
                //查询总条数
                int totalCount = getPageQueryCount(boundSql, connection, metaObject);
                pageQuery.setTotalCount(totalCount);
            }
            //重写分页语句并加入分页参数
            overridePageSql(metaObject,boundSql);

        }

        return  invocation.proceed();
    }

    /**
     * 查询数据总条数
     * @param boundSql
     * @param connection
     * @param metaObject
     * @return
     * @throws Throwable
     */
    private int getPageQueryCount(BoundSql boundSql, Connection connection, MetaObject metaObject) throws Throwable {
        //分页查询参数
        PageQuery pageQuery= (PageQuery) boundSql.getParameterObject();
        //获取绑定sql
        String sql=boundSql.getSql();
        //数据库连接
        //查询数据总条数
        PreparedStatement countQuery = connection.prepareStatement(
                dialect.generateCountSql(sql));

        MappedStatement ms= (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        ParameterHandler parameterHandler = new DefaultParameterHandler(ms,
                pageQuery, boundSql);
        parameterHandler.setParameters(countQuery);
        ResultSet rs=countQuery.executeQuery();
        int totalCount = 0;
        try {
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
        } finally {
            rs.close();
            countQuery.close();
        }
        return totalCount;
    }


    /**
     * 重写分页sql语句，并加入分页参数
     * @param metaObject
     * @param boundSql
     */
    private void overridePageSql(MetaObject metaObject, BoundSql boundSql){
        //boundSql关联的参数集合
        List<ParameterMapping> parameterMappingList=boundSql.getParameterMappings();

        //参数为空时，参数集合不可个性，这里要加入分页参数，所以重写了boundSql关联的参数集合
        if(parameterMappingList.size()==0){
            parameterMappingList= new ArrayList<>();
            metaObject.setValue("delegate.boundSql.parameterMappings",parameterMappingList);

        }
        Configuration configuration= (Configuration) metaObject.getValue("delegate.configuration");
        //加入分页参数
        parameterMappingList.add(new ParameterMapping.Builder(
                configuration, "offset", configuration.getTypeHandlerRegistry().getTypeHandler(int.class)).build());
        parameterMappingList.add(new ParameterMapping.Builder(
                configuration, "pageSize", configuration.getTypeHandlerRegistry().getTypeHandler(int.class)).build());

        //重写sql语句
        metaObject.setValue("delegate.boundSql.sql",dialect.generatePageSql(boundSql.getSql()));
    }
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }


    @Override
    public void setProperties(Properties properties) {
        try {
            setDbType((String) properties.get("dbType"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }

     private void setDbType(String dbType) throws ConfigurationException {
        this.dbType = dbType;
        switch (dbType){
            case DB_MYSQL:
                dialect= MySqlDialect.getInstance();
                break;
            case DB_ORCLE:
                dialect= OracleDialect.getInstance();
                break;
            default:
                throw new ConfigurationException("暂不支持此类型数据库");
        }
    }
}
