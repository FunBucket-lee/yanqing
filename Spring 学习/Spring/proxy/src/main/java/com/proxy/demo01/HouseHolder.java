package com.proxy.demo01;

public class HouseHolder implements Rent {

    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
