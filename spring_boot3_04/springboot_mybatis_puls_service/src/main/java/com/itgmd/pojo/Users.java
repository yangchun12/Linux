package com.itgmd.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName
public class Users {
    @TableId
    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer type;
    private Integer money;
}
