package com.cp.builder.demo02;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.changeDrink("雪碧").changeMain("不吃").changeSnake("薯条");
        Product product = worker.getProduct();
        System.out.println(product);
    }
}
