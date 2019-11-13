package com.cp.builder.demo02;

public class Product {
    private String main="汉堡";
    private String drink="可乐";
    private String snake="鸡块";

    @Override
    public String toString() {
        return "Product{" +
                "main='" + main + '\'' +
                ", drink='" + drink + '\'' +
                ", snake='" + snake + '\'' +
                '}';
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setSnake(String snake) {
        this.snake = snake;
    }
}
