package com.cp.builder.demo01;

//建房子
public abstract class Builder {
    //四道工序
    abstract public void buildA();
    abstract public void buildB();
    abstract public void buildC();
    abstract public void buildD();

    abstract public Product getProduct();
}
