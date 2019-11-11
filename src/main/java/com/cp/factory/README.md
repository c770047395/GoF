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
