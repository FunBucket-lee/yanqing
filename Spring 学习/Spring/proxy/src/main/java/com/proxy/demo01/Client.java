package com.proxy.demo01;

public class Client {
    public static void main(String[] args) {
        HouseHolder houseHolder = new HouseHolder();
        HouseProxy houseProxy = new HouseProxy(houseHolder);
        houseProxy.rent();
    }
}
