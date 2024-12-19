package com.itgmd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itgmd.mapper.UserMapper;
import com.itgmd.pojo.Users;
import com.itgmd.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {
}
