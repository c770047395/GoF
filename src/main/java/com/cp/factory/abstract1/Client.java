package com.cp.factory.abstract1;

public class Client {
    public static void main(String[] args) {
        System.out.println("========小米系列产品======");
        ProductFactory factory = new XiaomiFactory();
        PhoneProduct phone = factory.phoneProduct();
        RouterProduct router = factory.routerProduct();
        phone.sendSMS();
        router.start();
    }
}
