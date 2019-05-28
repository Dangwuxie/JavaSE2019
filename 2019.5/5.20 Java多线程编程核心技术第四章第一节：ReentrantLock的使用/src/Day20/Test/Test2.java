package Day20.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 再次使用ReentrantLock实现同步
 */
class MyService2{
    private ReentrantLock lock = new ReentrantLock();
    public void methodA(){
        try{
            lock.lock();
            System.out.println("方法A启动+"+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("方法A结束+"+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void methodB(){
        try{
            lock.lock();
            System.out.println("方法B启动+"+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("方法B结束+"+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class Thread2A extends Thread{
    private MyService2 myService2;

    public Thread2A(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.methodA();
    }
}
class Thread2AA extends Thread{
    private MyService2 myService2;

    public Thread2AA(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.methodA();
    }
}
class Thread2B extends Thread{
    private MyService2 myService2;

    public Thread2B(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.methodB();
    }
}
class Thread2BB extends Thread{
    private MyService2 myService2;

    public Thread2BB(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.methodB();
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyService2 myService2 = new MyService2();
        Thread2A a = new Thread2A(myService2);
        a.setName("a");
        a.start();
        Thread2AA aa = new Thread2AA(myService2);
        aa.setName("aa");
        aa.start();
        Thread2B b = new Thread2B(myService2);
        b.setName("b");
        b.start();
        Thread2BB bb = new Thread2BB(myService2);
        bb.setName("bb");
        bb.start();

    }
}
