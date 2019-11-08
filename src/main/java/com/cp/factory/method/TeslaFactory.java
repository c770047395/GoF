package com.cp.factory.method;

import com.cp.factory.method.CarFactory;

public class TeslaFactory implements CarFactory {
    public Car getCar() {
        return new Tesla();
    }
}
