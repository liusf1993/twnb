package com.lsf.twnb.service.impl;

import com.lsf.twnb.dao.UserMapper;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liusf13201 on 2015/11/18.
 */
@Component
public class UserServiceImpl implements IUserService
{
    @Autowired
    UserMapper entityMapper;

    @Override
    public void insert(User user)
    {
        entityMapper.insert(user);
    }

    @Override
    public void updateById(User user)
    {
        entityMapper.updateById(user);
    }

    @Override
    public User getUserByName(String username) {
        return entityMapper.getUserByName(username);
    }

    @Override
    public User checkUserLogin(User user) {
        User dbUser=entityMapper.getUserByName(user.getUsername());
        if(dbUser==null){
            return null;
        }
        if(dbUser.getPassword().equals(user.getPassword())){
            dbUser.hidePassword();
            return dbUser;
        }else{
            return null;
        }
    }
}
