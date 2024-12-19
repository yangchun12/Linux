package com.itgmd.mapper;

import com.itgmd.pojo.Users;

import java.util.List;

public interface UsersMapper {
    //增加用户
    int addUser(Users users);
    //删除
    int deleteUser(int id);
    //修改
    int updateUsers(Users users);
    //查询
    List<Users> queryUsers();
    Users queryUsersId(int id);
}

