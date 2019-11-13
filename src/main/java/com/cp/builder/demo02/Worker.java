package com.cp.builder.demo02;

public class Worker extends Build {

    private Product product;

    public Worker(){
        product = new Product();
    }

    @Override
    public Build changeMain(String main) {
        product.setMain(main);
        System.out.println("main更换为"+main);

        return this;
    }

    @Override
    public Build changeDrink(String drink) {
        product.setDrink(drink);
        System.out.println("drink更换为"+drink);
        return this;
    }

    @Override
    public Build changeSnake(String snake) {
        product.setSnake(snake);
        System.out.println("snake更换为"+snake);

        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
