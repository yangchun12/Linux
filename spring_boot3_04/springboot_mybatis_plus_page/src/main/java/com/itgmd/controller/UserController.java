package com.itgmd.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("queryPage")
    @ResponseBody
    public String queryPage(String pageNum){

        return userService.queryUserPage(Integer.parseInt(pageNum)).toString();
    }
    @GetMapping("queryMoney")
    @ResponseBody
    public String queryPage(String pageNum,String money){
        return userService.queryUsersMoney(Integer.parseInt(pageNum),Integer.parseInt(money)).toString();
    }
    @GetMapping("updateUsers")
    @ResponseBody
    public String updateUsers(String id){
       /*   UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
            updateWrapper.eq("user_id",id)
                    .set("user_name","张三")
                    .set("money",8000);*/
        LambdaUpdateWrapper<Users> updateWrapper=new LambdaUpdateWrapper<>();
        updateWrapper.eq(Users::getUserId,id)
                .set(Users::getUserName,"李四")
                .set(Users::getMoney,4000);
        return userService.update(updateWrapper)+"";
    }
}
