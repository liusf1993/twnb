package com.lsf.twnb.service.interfaces;

import com.lsf.twnb.entity.User;

/**
 * Created by liusf13201 on 2015/11/18.
 */
public interface IUserService
{
    void insert(User user);
    void updateById(User user);

    User getUserByName(String username);

    User checkUserLogin(User user);

    void deleteUserByUsername(String username);
}
