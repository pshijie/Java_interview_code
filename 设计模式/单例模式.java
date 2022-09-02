/**
 * @author psj
 * @date 2022/8/21 15:33
 * @File: Singleton.java
 * @Software: IntelliJ IDEA
 */
public class 单例模式 {

}

// 双重检查*：按需加载，线程安全，效率高
class DoubleCheck {
    private DoubleCheck() {
    }

    private volatile static DoubleCheck instance;

    public static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}

// 静态内部类*：线程安全，效率高，按需加载
class InnerClassSingleton{
    private InnerClassSingleton(){}

    private static class InnerClass{
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return InnerClass.instance;
    }

}

// 枚举*:线程安全，防止反序列化
enum EnumSinglton{
    INSTANCE;
}

// 饿汉式-静态变量：线程安全但是实例在类初始化时就创建
class HungryMan1 {
    private HungryMan1() {
    }

    private final static HungryMan1 instance = new HungryMan1();

    public static HungryMan1 getInstance() {
        return instance;
    }
}

// 饿汉式-静态代码块：线程安全但是实例在类初始化时就创建
class HungryMan2 {
    private HungryMan2() {
    }

    private final static HungryMan2 instance;

    static {
        instance = new HungryMan2();
    }

    public static HungryMan2 getInstance() {
        return instance;
    }
}

// 懒汉式-普通写法：按需加载但是线程不安全
class LazyMan1 {
    private LazyMan1() {
    }

    private static LazyMan1 instance;

    public static LazyMan1 getInstance() {
        if (instance == null) {
            instance = new LazyMan1();
        }
        return instance;
    }
}

// 懒汉式-同步方法：线程安全但是效率低
class LazyMan2{
    private LazyMan2(){}

    private static LazyMan2 instance;

    public synchronized static LazyMan2 getInstance(){
        if (instance == null){
            instance = new LazyMan2();
        }
        return instance;
    }
}
