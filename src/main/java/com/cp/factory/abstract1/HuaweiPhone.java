package com.cp.factory.abstract1;

public class HuaweiPhone implements PhoneProduct {

    public void start() {
        System.out.println("开启华为");
    }

    public void shutdown() {
        System.out.println("关闭华为");
    }

    public void callup() {
        System.out.println("华为打电话");
    }

    public void sendSMS() {
        System.out.println("华为发短信");
    }
}
