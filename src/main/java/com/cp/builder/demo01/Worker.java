package com.cp.builder.demo01;

public class Worker extends Builder {

    private Product product;

    public Worker(){
        product = new Product();
    }

    @Override
    public void buildA() {
        product.setBuildA("油漆");
        System.out.println("正在刷油漆");
    }

    @Override
    public void buildB() {
        product.setBuildB("水泥");
        System.out.println("正在铺水泥");
    }

    @Override
    public void buildC() {
        product.setBuildC("瓷砖");
        System.out.println("正在铺瓷砖");
    }

    @Override
    public void buildD() {
        product.setBuildD("装饰");
        System.out.println("正在做装饰");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
