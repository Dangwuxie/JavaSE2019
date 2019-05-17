package Day09.Test;
import java.io.Serializable;

//观察锁的可重入
class Service3{
    synchronized public void service1(){
        System.out.println("service1");
        service2();
    }
    synchronized public void service2(){
        System.out.println("service2");
        service3();
    }
    synchronized public void service3(){
        System.out.println("service3");

    }
}
class MyThread3 implements Runnable{
    @Override
    public void run() {
        Service3 service3 = new Service3();
        service3.service1();
    }
}
public class Test3 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        new Thread(myThread3).start();
    }
}
