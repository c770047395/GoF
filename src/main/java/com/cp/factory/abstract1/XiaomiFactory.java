package com.cp.factory.abstract1;

public class XiaomiFactory implements ProductFactory {
    public PhoneProduct phoneProduct() {
        return new XiaomiPhone();
    }

    public RouterProduct routerProduct() {
        return new XiaomiRouter();
    }
}
