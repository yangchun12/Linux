package com.itgmd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<Users> queryUserPage(Integer pageNum){
        Page<Users> page=new PageDTO<>(pageNum,2);
       /* QueryWrapper<Users> qw=new QueryWrapper<>();
        //qw.gt("money",2000);
        //qw.between("money",2000,3000);
        //qw.isNotNull("UserPassword");
        qw.likeRight("user_name","s")
                        .ge("money",2500)
                                .isNotNull("user_password");*/
       LambdaQueryWrapper<Users> lqw=new LambdaQueryWrapper<>();
        lqw.like(Users::getUserName,"s")
                      //  .ge(Users::getMoney,"2500")
                                .isNotNull(Users::getUserPassword);
        userMapper.selectPage(page,lqw);
        return page.getRecords();
    }
    @Override
    public List<Users> queryUsersMoney(Integer pageNum,Integer money){
        IPage<Users> page=new Page<>(pageNum,2);
        userMapper.queryUsersMoney(page,money);
        return page.getRecords();
    }
}
