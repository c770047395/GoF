package com.cp.singleton;

//DCL懒汉式
public class SingletonDemo03 {

    //1.私有构造器
    private SingletonDemo03(){
    }

    //2.类初始化的时候，不立即加载该对象
    private static SingletonDemo03 instance;

    //3.提供获取该对象的方法
    public static  SingletonDemo03 getInstance(){
        if(instance==null){
            synchronized (SingletonDemo03.class){
                if(instance==null){
                    instance = new SingletonDemo03();
                }
            }
        }
        return instance;
    }
}
