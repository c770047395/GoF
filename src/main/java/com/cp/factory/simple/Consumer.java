package com.cp.factory.simple;

//静态工厂模式
//弊端：不修改代码做不到

public class Consumer {
    public static void main(String[] args){
//        Car car = new WuLin();
//        Car car1 = new Tesla();

        //使用工厂创建
        Car car = CarFactory.getCar("五菱");
        Car car1 = CarFactory.getCar("特斯拉");
        car.name();
        car1.name();
    }
}
