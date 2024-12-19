package com.itgmd.controller;

import com.itgmd.pojo.Users;
import com.itgmd.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@CrossOrigin//跨域支持
public class UsersController {

    @Autowired
    UsersService usersService;
    @GetMapping("/query")
    public String queryUsers(Model model){
        List<Users> usersList=usersService.queryUsers();
        model.addAttribute("usersList",usersList);//存储集合
        return "index";
    }
    @GetMapping("/queryUserId")
    public String queryUsersId(int id,Model model){
       Users users=usersService.queryUsersId(id);
       model.addAttribute("users",users);
        return "update";
    }

    @PostMapping ("/add")
    public String addUsers(Users users){
        boolean fig=usersService.addUsers(users);
        if (fig){
            return "redirect:query";//转发
        }else {
            return "error";
        }
    }
    @GetMapping ("/delete")
    public String deleteUsers(int id){
        boolean fig=usersService.deleteUsers(id);
        if (fig){
            return "redirect:query";
        }else {
            return "error";
        }
    }
    @PostMapping ("/update")
    public String updateUsers(Users users){
        boolean fig=usersService.updateUsers(users);
        if (fig){
            return "redirect:query";//转发
        }else {
            return "error";
        }
    }
}
