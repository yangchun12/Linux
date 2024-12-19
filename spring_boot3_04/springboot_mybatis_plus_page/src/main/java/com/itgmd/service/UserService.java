package com.itgmd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itgmd.pojo.Users;

import java.util.List;

public interface UserService extends IService<Users> {
   List<Users> queryUserPage(Integer pageNum);
   List<Users> queryUsersMoney(Integer pageNum,Integer money);
}
