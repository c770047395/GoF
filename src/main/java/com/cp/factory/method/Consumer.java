package com.cp.factory.method;

//静态工厂模式
//弊端：不修改代码做不到


public class Consumer {
    public static void main(String[] args){
        //使用工厂方法创建
        Car car = new TeslaFactory().getCar();


        car.name();

    }
}
