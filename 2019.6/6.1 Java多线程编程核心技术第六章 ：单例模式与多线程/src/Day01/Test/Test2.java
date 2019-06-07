package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: Test2
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 立即加载/饿汉模式
 * 就是说调用get方法的时候实例才被创建；
 * @date 2019/6/7 9:22
 */

class MyObject2{
    private static MyObject2 myObject2;
    public MyObject2() {
    }
    public static MyObject2 getInstance(){
        if (myObject2 == null){
            myObject2 = new MyObject2();
        }
        return myObject2;
    }
}
class Thread2 extends Thread{

    @Override
    public void run() {
        System.out.println(MyObject2.getInstance().hashCode());
    }
}
public class Test2 {

    public static void main(String[] args) {
        Thread2 t1 = new Thread2();
        t1.start();
    }
}
/*
运行结果：

    1839047274
 */