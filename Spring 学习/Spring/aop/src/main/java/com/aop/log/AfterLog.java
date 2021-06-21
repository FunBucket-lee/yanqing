package com.aop.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnvalue, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("执行了" + target.getClass().getName() + "的方法，返回值为" + returnvalue);
    }
}
