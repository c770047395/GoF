package com.cp.singleton;

//饿汉式单例
public class SingletonDemo01 {
    //私有化构造器
    private SingletonDemo01(){

    }

    //类初始化的时候立即加载该对象
    private static SingletonDemo01 instance = new SingletonDemo01();

    //提供获取对象的方法
    public static SingletonDemo01 getInstance(){
        return instance;
    }
}
