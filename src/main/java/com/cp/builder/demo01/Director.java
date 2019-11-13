package com.cp.builder.demo01;

public class Director {
    public Product getProduct(Builder worker){
        worker.buildA();
        worker.buildB();
        worker.buildC();
        worker.buildD();
        return worker.getProduct();
    }
}
