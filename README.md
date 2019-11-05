# 设计模式

## 1.单例模式
单例模式下，一个类在全局只有一个实例，具体有五种实现
### 1.1 饿汉式单例模式
创建一个饿汉式单例类有三个步骤
1. 添加私有构造函数：使其他地方无法new出新的实例
2. 在类中定义一个静态的实例：在类加载时就创建
3. 添加一个公开的获取实例的方法
```java
//饿汉式单例
public class SingletonDemo01 {
    //私有化构造器
    private SingletonDemo01(){

    }

    //类初始化的时候立即加载该对象
    private static SingletonDemo01 instance = new SingletonDemo01();

    //提供获取对象的方法，由于在类加载时创建了实例，不用同步，效率高
    public static SingletonDemo01 getInstance(){
        return instance;
    }
}
```
由于在类初始化时就要加载对象，如果这个类未被使用，将白白浪费空间，所以引出了懒汉式单例

### 1.2 懒汉式单例模式
与饿汉式单例不同，懒汉式单例在类加载时不新建对象，而是等到被调用时再新建，同样，创建一个懒汉式单例例子也有三步：
1. 私有化构造函数
2. 定义一个静态实例变量，但是不初始化
3. 添加公共的获取实例的方法，在方法中判断实例有无生成
```java
public class SingletonDemo02{
    //1. 私有化构造函数
    private SingletonDemo02(){}
    //2. 定义一个静态实例变量，但是不初始化
    private static SingletonDemo02 instance;
    //3. 添加公共的获取实例的方法，在方法中判断实例有无生成
    public static synchronized SingletonDemo02 getInstance(){
        if(instance==null){
            instance = new SingletonDemo02();
        }
        return instance;
    }

}
```
由于是在第一次获取实例的时候新建对象，如果在高并发情况下可能出现问题，所以要加上sychronized关键字让方法同步，但是会影响效率，所以又引出了DCL模式

### 1.3 DCL（双重检测锁）懒汉单例模式
DCL与普通懒汉式相似，但是采用 synchronized代码块来代替synchronized方法：
```java
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
```
可以看出，DCL模式没有在方法中使用synchronized关键字，所以只有在实例刚被多个线程调用时会执行同步代码块，在线程拿到锁之后再判断一次实例是否被创建，
以此确保自己是第一个拿到锁的，然后才新建实例。但是在某些极端情况下，会在前一个线程还没离开时又有线程进入代码块，导致一些不可预见的错误。

### 1.4 通过静态内部类实现懒汉式单例
静态内部类只有在外部类第一次被调用的时候才会加载，以此可以达到懒加载的目的
```java
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

```
通过静态内部类创建的实例不会有线程安全问题，看似很完美，但是无法避免用反射加载多个实例，之前的方法也无法避免用反射加载多个实例，
但是反射无法反射枚举对象，所以可以使用枚举来防止使用反射创建多个实例