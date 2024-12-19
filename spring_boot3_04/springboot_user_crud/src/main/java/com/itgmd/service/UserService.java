package com.itgmd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itgmd.pojo.Users;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService extends IService<Users> {
    List<Users> queryUserPage(Integer pageNum);//按条件来给用户分页
    List<Users> queryUserAllPage(Integer pageNum);//全部用户已分页

}
