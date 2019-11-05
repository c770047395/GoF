package com.cp.singleton;
//静态内部类实现
public class SingletonDemo04 {
    private SingletonDemo04(){}

    private static class InnerClass{
        private static final SingletonDemo04 instance = new SingletonDemo04();
    }

    public static SingletonDemo04 getInstance(){
        return InnerClass.instance;
    }
}
