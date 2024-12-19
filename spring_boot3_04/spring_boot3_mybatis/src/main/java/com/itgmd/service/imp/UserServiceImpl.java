package com.itgmd.service.imp;

import com.itgmd.mapper.UserMapper;
import com.itgmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Transactional
    @Override
        public boolean updateMoney(int id1, int id2) {
            int num1=userMapper.update1(id1);
           // int sum=1/0;
            int num2=userMapper.update2(id2);
            return num1+num2==2;
        }
}
