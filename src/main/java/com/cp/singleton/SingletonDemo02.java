package com.cp.singleton;

//懒汉式单例
public class SingletonDemo02 {

    //1.私有构造器
    private SingletonDemo02(){
    }

    //2.类初始化的时候，不立即加载该对象
    private static SingletonDemo02 instance;

    //3.提供获取该对象的方法,有synchronized，效率较低
    public static synchronized SingletonDemo02 getInstance(){
        if(instance==null){
            instance = new SingletonDemo02();
        }
        return instance;
    }
}
