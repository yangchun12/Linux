package com.itgmd.controller;

import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/query")
    @ResponseBody
    public String queryUsers(){

        return userService.queryUsers().toString();
    }
    @GetMapping("/queryId")
    @ResponseBody
    public String queryUsers(String id){

        return userService.queryUserId(Integer.parseInt(id)).toString();
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteUsers(Integer id){
        System.out.println(id);
        return userService.deleteUser(id)+"";
    }
    @DeleteMapping("/deleteList")
    @ResponseBody
    public String deleteUsersList(){
        List<Integer> idList=new ArrayList<>();
        idList.add(3);
        idList.add(4);
        idList.add(5);

        return userService.deleteUsersLis(idList)+"";
    }
    @DeleteMapping("/deleteName")
    @ResponseBody
    public String deleteUsersName(String userName){

        return userService.deleteUsersName(userName)+"";
    }
    @PutMapping("/updateUsers")
    @ResponseBody
    public String updateUsers(){
        Users users=new Users();
        users.setUserId(1);
        users.setUserName("张三");
        users.setUserPassword("654321");
        return userService.updateUsers(users)+"";
    }
    @PostMapping("/addUsers")
    @ResponseBody
    public String addUsers(){
        Users users=new Users();
        users.setUserName("张三1");
        users.setUserPassword("654321");
        users.setType(2);
        users.setMoney(2000);
        return userService.addUsers(users)+"";
    }

}