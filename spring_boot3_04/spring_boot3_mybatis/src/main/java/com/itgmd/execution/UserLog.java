package com.itgmd.execution;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLog {
    @Before("execution(* com..service.*.updateMoney(..))")
    public void before(){
        System.out.println("开始转账");
    }
}