package com.lsf.twnb.dao;

import com.lsf.twnb.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    public void insert(User user);

    public void updateById(User user);

    @Select("select u.* from User u where u.username=#{username}")
    public User getUserByName(@Param("username") String username);
}