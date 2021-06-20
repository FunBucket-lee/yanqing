package com.proxy.demo01;

public class HouseProxy implements Rent {
    private HouseHolder houseHolder;

    public HouseProxy() {
    }

    public HouseProxy(HouseHolder houseHolder) {
        this.houseHolder = houseHolder;
    }

    @Override
    public void rent() {
        seeHouse();
        houseHolder.rent();
        Contrat();
        fee();
    }

    //看房子
    public void seeHouse(){
        System.out.println("带客户看房");
    }

    //签合同
    public void Contrat(){
        System.out.println("签租赁合同");
    }

    //收中介费
    public void fee(){
        System.out.println("收取中介费");
    }
}
