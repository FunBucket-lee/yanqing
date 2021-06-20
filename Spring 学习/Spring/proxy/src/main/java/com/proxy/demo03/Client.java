package com.proxy.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        HouseHolder houseHolder = new HouseHolder();

        //代理角色，目前没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        //通过程序处理角色来处理我们要调用的接口对象
        pih.setRent(houseHolder);

        Rent proxy = (Rent) pih.getProxy();

        proxy.rent();

    }
}
