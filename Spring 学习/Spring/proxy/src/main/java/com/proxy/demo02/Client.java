package com.proxy.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ServiceProxy serviceProxy = new ServiceProxy();
        serviceProxy.setUserService(userService);
        serviceProxy.add();
    }
}
