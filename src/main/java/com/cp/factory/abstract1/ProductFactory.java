package com.cp.factory.abstract1;

//抽象产品工厂
public interface ProductFactory {

    //生产手机
    PhoneProduct phoneProduct();
    //生产路由器
    RouterProduct routerProduct();
}
