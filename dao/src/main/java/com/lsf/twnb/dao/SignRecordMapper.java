package com.lsf.twnb.dao;

import com.lsf.twnb.entity.SignRecord;
import org.apache.ibatis.annotations.*;

public interface SignRecordMapper {
    @Delete({
        "delete from SignRecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into SignRecord (id, Sign_type, ",
        "Sign_date, Sign_time, Sign_user)",
        "values (#{id,jdbcType=INTEGER}, #{SignType,jdbcType=VARCHAR}, ",
        "#{SignDate,jdbcType=DATE}, #{SignTime,jdbcType=TIME}, #{SignUser,jdbcType=VARCHAR})"
    })
    int insert(SignRecord record);

    int insertSelective(SignRecord record);

    @Select({
        "select",
        "id, Sign_type, Sign_date, Sign_time, Sign_user",
        "from SignRecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    SignRecord selectByPrimaryKey(Integer id);


    @Update({
        "update SignRecord",
        "set Sign_type = #{SignType,jdbcType=VARCHAR},",
          "Sign_date = #{SignDate,jdbcType=DATE},",
          "Sign_time = #{SignTime,jdbcType=TIME},",
          "Sign_user = #{SignUser,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SignRecord record);
}