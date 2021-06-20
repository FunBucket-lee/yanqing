package com.proxy.demo02;

public class ServiceProxy implements UserService {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
        log("delete");
        System.out.println("删除了一个用户");
    }

    @Override
    public void alter() {
        log("alter");
        System.out.println("修改了一个用户");
    }

    @Override
    public void query() {
        log("query");
        System.out.println("查询了一个用户");
    }

    public void log(String s){
        System.out.println("[DeBug] 使用了一个"+s+"方法");
    }
}
