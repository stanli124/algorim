package createPatterns;

//饿汉式—方式1 静态变量方式
//public class singlePatterns {
//
//    private singlePatterns(){}
//
//    //instance在类加载的过程中而被创建的
//    private static singlePatterns instancce = new singlePatterns();
//
//    public static singlePatterns getInstance(){
//        return instancce;
//    }
//}


//饿汉式-方式2 静态代码块方式
//public class singlePatterns {
//
//    private singlePatterns(){}
//
//    //instance在类加载的过程中而被创建的
//    private static singlePatterns instancce;
//
//    //instance在静态代码块中创建该对象
//    static {
//        instancce = new singlePatterns();
//    }
//
//    public static singlePatterns getInstance(){
//        return instancce;
//    }
//}


/**
 * 懒汉式-方式1 线程不安全
 * 为了避免饿汉式提前加载对象到内存，可能造成的内存不足，改为在使用的时候才新建对象
 */
//public class singlePatterns {
//
//    private singlePatterns(){}
//
//    //instance在类加载的过程中而被创建的
//    private static singlePatterns instancce;
//
//    //对外提供访问方法，获取到单例
//    public static singlePatterns getInstance(){
//        //多线程的时候，可能会返回多个不同的instance实例
//        if (instancce==null){
//            instancce = new singlePatterns();
//        }
//        return instancce;
//    }
//}

/**
 * 懒汉式-方式2 线程安全
 * 实现懒加载和线程安全
 * 在初始化instance的时候才会出现线程安全问题，一旦初始化完成就不存在这个问题了
 */
//public class singlePatterns {
//
//    private singlePatterns(){}
//
//    //instance在类加载的过程中而被创建的
//    private static singlePatterns instancce;
//
//    public static synchronized singlePatterns getInstance(){
//        if (instancce==null){
//            instancce = new singlePatterns();
//        }
//        return instancce;
//    }
//}

/**
 * 懒汉式-方式3 双重检查锁
 */
//public class singlePatterns {
//
//    private singlePatterns(){}
//
//    //添加volatile关键字是为了保证可见性和有序性。
//    private static volatile singlePatterns instancce;
//
//    //大部分操作是读操作，是线程安全的，所以没必要让每个线程必须持有锁才能访问。
//    public static singlePatterns getInstance(){
//        if (instancce==null){
//            synchronized (singlePatterns.class){
//                if (instancce == null){
//                    instancce = new singlePatterns();
//                }
//            }
//        }
//        return instancce;
//    }
//}


/**
 * 懒汉式-方式4 静态内部类
 * JVM在加载外部类的过程中，不会加载静态内部类，只有内部类的属性/方法被调用的时候才会被加载，并从初始化其静态属性。
 * 由于被static修饰，所以可以保证该实例对象只被实例化一次。
 */
//public class singlePatterns {
//
//    private singlePatterns(){}
//
//
//    private static class singleHolder{
//        private static final singlePatterns INSTANCE = new singlePatterns();
//    }
//
//
//    public static singlePatterns getInstance(){
//        return singleHolder.INSTANCE;
//    }
//}


/**
 * 枚举方式
 * 除了枚举类型不会被破坏，其它类型的创建方式都可能被 序列化和反射的方式而破坏。
 */
enum singleTon{
    INSTANCE;
}



