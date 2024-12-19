package com.itgmd.service.imp;

import com.itgmd.mapper.UsersMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersMapper usersMapper;
   @Override
    public List<Users> queryUsers() {
        return usersMapper.queryUsers();
    }

    @Override
    public Users queryUsersId(int id) {
        return usersMapper.queryUsersId(id);
    }


    @Override
    public boolean addUsers(Users users) {
        return usersMapper.addUser(users)>0;
    }

    @Override
    public boolean deleteUsers(int id) {
        return usersMapper.deleteUser(id)>0;
    }

    @Override
    public boolean updateUsers(Users users) {
        return usersMapper.updateUsers(users)>0;
    }


}
