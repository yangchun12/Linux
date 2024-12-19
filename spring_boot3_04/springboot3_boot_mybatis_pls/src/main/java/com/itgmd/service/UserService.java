package com.itgmd.service;

import com.itgmd.pojo.Users;

import java.util.List;

public interface UserService {
    //查询所有
    List<Users> queryUsers();
    //根据id查询
    Users queryUserId(Integer id);
    //根据id删除
    Integer deleteUser(Integer id);
    //根据多个id删除
    Integer deleteUsersLis(List<Integer> idLis);
    //根据user_name字段删除
    Integer deleteUsersName(String userName);
    //根据id修改
    Integer updateUsers(Users users);
    //添加
    Integer addUsers(Users users);

}
