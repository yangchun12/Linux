package com.itgmd.service.impl;

import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<Users> queryUsers() {

        return userMapper.selectList(null);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return  userMapper.deleteById(id);
    }

    @Override
    public Integer deleteUsersLis(List<Integer> idLis) {

        return userMapper.deleteBatchIds(idLis);
    }

    @Override
    public Integer deleteUsersName(String userName) {
        Map map=new HashMap();
        map.put("user_name",userName);
        return userMapper.deleteByMap(map);
    }

    @Override
    public Integer updateUsers(Users users) {
        return userMapper.updateById(users);
    }

    @Override
    public Integer addUsers(Users users) {

        return userMapper.insert(users);
    }

    @Override
    public Users queryUserId(Integer id) {
        return userMapper.selectById(id);
    }



}
