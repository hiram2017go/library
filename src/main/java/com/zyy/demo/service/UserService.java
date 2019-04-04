package com.zyy.demo.service;

import com.zyy.demo.entity.User;

import java.util.List;

public interface UserService {

    public List<User> userList();

    public boolean addUser(User u);

    public User getUserById(String id);

    public boolean deleteUserById(String id);

    public boolean modifyUser(User u);
}
