package com.aop.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAop {

    @Before("execution(* com.aop.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("======方法执行前======");
    }

    @After("execution(* com.aop.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("======方法执行后======");
    }

    @Around("execution(* com.aop.service.UserServiceImpl.*(..))")
    public void aroud(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("======环绕前======");
//        System.out.println(jp.getSignature());
        Object proceed = jp.proceed();
        System.out.println("======环绕后======");

    }
}
