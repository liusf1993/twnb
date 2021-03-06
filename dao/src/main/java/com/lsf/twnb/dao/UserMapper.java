package com.lsf.twnb.dao;

import com.lsf.twnb.entity.User;
import com.lsf.twnb.query.concrete.UserPageQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    void insert(User user);

    void updateById(User user);

    @Select("select u.* from User u where u.username=#{username}")
    User getUserByName(@Param("username") String username);

    @Delete("delete from User where username=#{username}")
    void deleteUserByUsername(@Param("username") String username);


    List<User> queryUser(UserPageQuery userQuery);
}