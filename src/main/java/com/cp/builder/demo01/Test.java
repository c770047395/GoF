package com.cp.builder.demo01;

public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.getProduct(new Worker());
        System.out.println(product);
    }
}
