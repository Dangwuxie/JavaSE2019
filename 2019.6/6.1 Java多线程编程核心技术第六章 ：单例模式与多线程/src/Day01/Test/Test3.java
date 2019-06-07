package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: Test3
 * @ProjectName 6.1 Java多线程编程核心技术第六章 ：单例模式与多线程
 * @Description: 延迟加载/懒汉模式的缺点，在多线程环境下会取出多个对象；
 * 查看取出多个实例的情况；
 * @date 2019/6/7 9:28
 */

class MyObject3{
    private static MyObject3 myObject3;

    public MyObject3() {
    }

    public static MyObject3 getInstance(){
        try{
            if (myObject3 == null){
                Thread.sleep(2000);
                myObject3 = new MyObject3();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return myObject3;
    }
}
class Thread3 extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject3.getInstance().hashCode());
    }
}
public class Test3 {
    public static void main(String[] args) {
        Thread3 t1 = new Thread3();
        Thread3 t2 = new Thread3();
        Thread3 t3 = new Thread3();
        t1.start();
        t2.start();
        t3.start();

    }
}
/*
运行结果：
可以看出懒汉模式多线程实现了三个实例；三个不同的hashcode
    228428496
    676905244
    1211537232

 */