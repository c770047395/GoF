package com.cp.factory.method;

public class WuLinFactory implements CarFactory {
    public Car getCar() {
        return new WuLin();
    }
}
