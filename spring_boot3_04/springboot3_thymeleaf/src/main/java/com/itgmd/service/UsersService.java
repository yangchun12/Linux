package com.itgmd.service;

import com.itgmd.pojo.Users;

import java.util.List;

public interface UsersService {
    List<Users> queryUsers();
    Users queryUsersId(int id);
    //添加
    boolean addUsers(Users users);
    //删除
    boolean deleteUsers(int id);
    //修改
    boolean updateUsers(Users users);
}
