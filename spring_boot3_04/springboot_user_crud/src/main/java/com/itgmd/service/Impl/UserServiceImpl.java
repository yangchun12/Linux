package com.itgmd.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    // 分页查询用户
    @Override
    public List<Users> queryUserPage(Integer pageNum){
        Page<Users> page=new PageDTO<>(pageNum,2);
        LambdaQueryWrapper<Users> lqw=new LambdaQueryWrapper<>();
        lqw.like(Users::getUserName,"s")
                //  .ge(Users::getMoney,"2500")
                .isNotNull(Users::getUserPassword);
        userMapper.selectPage(page,lqw);
        return page.getRecords();
    }

    // 查询所有用户
    @Override
    public List<Users> queryUserAllPage(Integer pageNum) {
        // 设置分页信息，pageNum为当前页码，2为每页的记录数
        Page<Users> page = new Page<>(pageNum, 2);
        // 查询所有用户
      userMapper.selectPage(page, null);

        // 返回当前页的数据
        return page.getRecords();
    }

}
