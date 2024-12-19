package com.itgmd.mapper;

import com.itgmd.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    Users queryUsers();//使用mapper.xml

    @Select("select * from users")
    List<Users> queryUserAll();
    int update1(int id);
    int update2(int id);
}
