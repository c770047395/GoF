# 工厂模式


## 1. 简单（静态）工厂模式
先从最原始的面相对象开始说起，以车为例：
首先有个车的接口：
```java
public interface Car {
    void name();
}
```
实现了这个接口的都是车，下面添加两种车：
```java
public class WuLin implements Car {
    public void name() {
        System.out.println("五菱宏光！");
    }
}

public class Tesla implements Car {
    public void name() {
        System.out.println("特斯拉");
    }
}
```
此时消费者在使用车时，需要new出车的对象才能使用：
```java
public class Consumer {
    public static void main(String[] args){
        Car car = new WuLin();
//        Car car1 = new Tesla();
        car.name();
//        car1.name();
    }
}
```
这样做十分麻烦，耦合性高，想换车必须新new一个对象

这时工厂模式就可以大显神通了

首先，创建一个工厂：
```java
public class CarFacotry {
    public static Car getCar(String car){
        if(car.equals("五菱")){
            return new WuLin();
        }else if (car.equals("特斯拉")){
            return new Tesla();
        }else{
            return null;
        }
    }
}
```
工厂将所有的车都放在了里面，此时我们只需要使用静态方法getCar并传入想要的车的名字
就可以获取想要的车，大大降低了耦合性
```java
public class Consumer {
    public static void main(String[] args){
        Car car = CarFacotry.getCar("五菱");
//        Car car1 = CarFacotry.getCar("特斯拉");
        car.name();
//        car1.name();
    }
}
```
但是这样的工厂并不完美，如果我们加了一辆新车，必须得修改工厂的代码，这不符合开闭原则，这也是静态工厂的弊端，所以有了工厂方法模式

## 2.工厂方法模式
如果我们无法对工厂进行修改，只能对工厂进行拓展，那么我们就不能将所有工厂写在一个工厂类之中，而是要定义一个接口，让其他类来实现工厂，这也是比较符合实际情况的
```java
//工厂方法模式
public interface CarFactory {
    Car getCar();
}
```
实现：
```java
public class WuLinFactory implements CarFactory {
    public Car getCar() {
        return new WuLin();
    }
}

public class TeslaFactory implements CarFactory {
    public Car getCar() {
        return new Tesla();
    }
}

```
如此一来，如果有新的车加入，我们只需要写一个新的工厂就好了，不需要对原有工厂进行修改，符合了开闭原则，但是每多一个类，需要定义类和类的工厂

## 3.静态工厂模式对比工厂方法模式

- 结构复杂度： 静态工厂简单
- 代码复杂度： 静态工厂简单
- 变成复杂度： 静态工厂简单
- 管理上的复杂度： 静态工厂简单

可见工厂方法模式只是符合了开闭原则的规范，但是实际上并没有静态工厂实用，所以实际使用还是静态工厂比较多

## 4.抽象工厂模式
抽象工厂就是生产工厂的工厂！

例如我们原来有两个产品Phone以及Router，我们定义了一个工厂可以生成这两个产品，只需要定义一个接口
```java
//抽象产品工厂
public interface ProductFactory {

    //生产手机
    PhoneProduct phoneProduct();
    //生产路由器
    RouterProduct routerProduct();
}
```
具体的实现交给具体工厂去管理

最后的使用
```java
public class Client {
    public static void main(String[] args) {
        System.out.println("========小米系列产品======");
        ProductFactory factory = new XiaomiFactory();
        PhoneProduct phone = factory.phoneProduct();
        RouterProduct router = factory.routerProduct();
        phone.sendSMS();
        router.start();
    }
}
```

值得一提的是，抽象工厂只有在系统的产品有多于一个的产品族，而消费者只消费其中一个时使用，
可以保持客户端始终只使用同一个产品中的对象

使用场景：qq换一套皮肤，每个组件都会一起换