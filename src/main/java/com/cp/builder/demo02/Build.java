package com.cp.builder.demo02;

public abstract class Build {

    public abstract Build changeMain(String main);
    public abstract Build changeDrink(String drink);
    public abstract Build changeSnake(String snake);


    public abstract Product getProduct();




}
