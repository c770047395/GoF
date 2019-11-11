package com.cp.factory.abstract1;

public class HuaweiFactory implements ProductFactory {
    public PhoneProduct phoneProduct() {
        return new HuaweiPhone();
    }

    public RouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
