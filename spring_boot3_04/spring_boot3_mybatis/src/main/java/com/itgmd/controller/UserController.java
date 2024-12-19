package com.itgmd.controller;


import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @GetMapping
    public Users queryUsers(){

        Users users=userMapper.queryUsers();

        return users;
    }
    @PostMapping
    public List<Users> queryUsersAll(){

        List<Users> usersList=userMapper.queryUserAll();

        return usersList;
    }
    @PutMapping
    public String updateMoney(){
        boolean fig= userService.updateMoney(1,2);
        if (fig){
            return "转账成功";
        }else {
            return "转账失败";

        }
    }
}
