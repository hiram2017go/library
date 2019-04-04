package com.zyy.demo.dao;

import com.zyy.demo.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> queryUserList();

    public int insertUser(User u);

    public User queryUserById(String id);

    public int deleteUserById(String id);

    public int updateUser(User u);
}
