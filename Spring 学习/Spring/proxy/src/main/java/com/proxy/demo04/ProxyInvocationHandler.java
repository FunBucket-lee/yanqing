package com.proxy.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//万能动态代理
public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Proxy getProxy() {
        return (Proxy) Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       log(method.getName());
        Object res = method.invoke(target, args);
        return res;
    }

    //下面可以自定义动态代理方法
    public void log(String s) {
        System.out.println("[DeBug] 调用了" + s + "方法");
    }
}
