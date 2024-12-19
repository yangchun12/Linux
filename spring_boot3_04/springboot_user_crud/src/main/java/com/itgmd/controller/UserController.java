package com.itgmd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    //分页
    @GetMapping("queryUsersPage")

    public String queryUsersPage(Model model,Integer pageNum){
        List<Users> usersList=userService.queryUserPage(pageNum);
        model.addAttribute("usersList",usersList);//存储集合
        model.addAttribute("pageNum",pageNum);
        return "fenye";
    }
    //分页
    @GetMapping("queryUserAllPage")

    public String queryUserAllPage(Model model,Integer pageNum){
        List<Users> usersList=userService.queryUserAllPage(pageNum);
        model.addAttribute("usersList",usersList);//存储集合
        model.addAttribute("pageNum",pageNum);
        return "AllPage";
    }
    //查询所有
    @GetMapping("/query")
    public String query(Model model){
        List<Users> usersList=userService.list();
        model.addAttribute("usersList",usersList);//存储集合
        return "index";
    }
    //查询
    @GetMapping("/queryUserId")
    public String queryUsersId(Integer id,Model model){
        Users users=userService.getById(id);
        model.addAttribute("users",users);
        return "update";
    }
//添加用户
    @PostMapping ("/add")
    public String addUsers(Users users){
        boolean fig=userService.save(users);
        if (fig){
            return "redirect:query";//转发
        }else {
            return "error";
        }
    }
    @GetMapping ("/delete")
    public String deleteUsers(Integer id){
        boolean fig=userService.removeById(id);
        if (fig){
            return "redirect:query";
        }else {
            return "error";
        }
    }
    @PostMapping ("/update")
    public String updateUsers(Users users){
        boolean fig=userService.updateById(users);
        if (fig){
            return "redirect:query";//转发
        }else {
            return "error";
        }
    }
}
