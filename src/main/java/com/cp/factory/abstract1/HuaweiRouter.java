package com.cp.factory.abstract1;

public class HuaweiRouter implements RouterProduct {
    public void start() {
        System.out.println("启动华为路由器");
    }

    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    public void openWifi() {
        System.out.println("打开华为wifi");
    }

    public void setting() {
        System.out.println("华为设置");
    }
}
