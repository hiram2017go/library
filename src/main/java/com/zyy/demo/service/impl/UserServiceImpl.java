package com.zyy.demo.service.impl;

import com.zyy.demo.dao.UserDao;
import com.zyy.demo.entity.User;
import com.zyy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> userList() {
        return userDao.queryUserList();
    }

    @Override
    public boolean addUser(User u) {
        if(u == null) throw new IllegalArgumentException("传入参数异常");
        int num = userDao.insertUser(u);
        return num > 0;
    }

    @Override
    public User getUserById(String id) {
        return userDao.queryUserById(id);
    }

    @Override
    public boolean deleteUserById(String id) {
        User u = userDao.queryUserById(id);
        if(u == null) throw new IllegalArgumentException("不存在该用户");
        return userDao.deleteUserById(id) > 0;
    }

    @Override
    public boolean modifyUser(User u) {
        return userDao.updateUser(u) > 0;
    }
}
