package com.proxy.demo03;

import com.proxy.demo03.Rent;

public class HouseHolder implements Rent {

    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
