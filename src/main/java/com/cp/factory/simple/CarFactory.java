package com.cp.factory.simple;

public class CarFactory {
    public static Car getCar(String car){
        if(car.equals("五菱")){
            return new WuLin();
        }else if (car.equals("特斯拉")){
            return new Tesla();
        }else{
            return null;
        }
    }
}
