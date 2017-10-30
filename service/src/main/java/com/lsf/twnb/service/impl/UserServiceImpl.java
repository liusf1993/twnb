package com.lsf.twnb.service.impl;

import com.lsf.twnb.dao.UserMapper;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.stereotype.Component;
import com.lsf.twnb.query.concrete.UserPageQuery;

/**
 * Created by liusf13201 on 2015/11/18.
 */
@Component(value = "userService")
public class UserServiceImpl implements IUserService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public UserPageQuery getUserByName(String username) {
        UserPageQuery userQuery = new UserPageQuery();
        userQuery.setUsername(username);
        userQuery.setItems(userMapper.queryUser(userQuery));
        return userQuery;
    }

    @Override
    public User checkUserLogin(User user) {
        User dbUser = userMapper.getUserByName(user.getUsername());
        if (dbUser == null) {
            return null;
        }
        if (dbUser.getPassword().equals(user.getPassword())) {
            dbUser.hidePassword();
            return dbUser;
        } else {
            return null;
        }
    }
    @Override
    public void deleteUserByUsername(String username) {
        userMapper.deleteUserByUsername(username);
    }
}
