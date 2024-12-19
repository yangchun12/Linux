package com.itgmd.controller;

import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    //查询所有用户
    @Autowired
    UserService userService;
    @GetMapping("queryAll")
    @ResponseBody
    public String queryAll(){
        return userService.list().toString();
    }
    //查询指定用户
    @GetMapping("queryId")
    @ResponseBody
    public String queryId(String id){
        System.out.println(id);
        return userService.getById(Integer.parseInt(id)).toString();
    }
    //查询用户名
    @GetMapping("queryName")
    @ResponseBody
    public String queryName(String userName){
        Map map=new HashMap<>();
        map.put("user_name",userName);
        return userService.listByMap(map).toString();
    }
    //添加
    @GetMapping("addUsers")
    @ResponseBody
    public String addUsers(){
        Users users=new Users();
        users.setUserName("sssdw");
        users.setUserPassword("4321");
        users.setType(1);
        users.setMoney(2221);
        return userService.save(users)+"";
    }
    //修改
    @GetMapping("updateUsers")
    @ResponseBody
    public String updateUsers(){
        Users users=new Users();
        users.setUserId(1);
        users.setUserName("ssder");
        users.setUserPassword("43210");
        users.setType(1);
        users.setMoney(2221);
        return userService.updateById(users)+"";
    }
    //删除
    @GetMapping("deleteUsers")
    @ResponseBody
    public String deleteUsers(){

        return userService.removeById(20)+"";
    }
    //批量删除
    @GetMapping("deleteUsersList")
    @ResponseBody
    public String deleteUsersList(){
        List<Integer> idList=new ArrayList<>();
        idList.add(19);
        idList.add(6);

        return userService.removeBatchByIds(idList)+"";
    }
}
