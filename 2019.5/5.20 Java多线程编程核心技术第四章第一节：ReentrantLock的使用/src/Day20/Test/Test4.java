package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用多个Condition实现通知部分线程启动
 */

class MyService4{
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public void awaitA1(){
        try{
            lock.lock();
            System.out.println("A1线程开始时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("A1线程结束时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void awaitA2(){
        try{
            lock.lock();
            System.out.println("A2线程开始时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("A2线程结束时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void awaitB1(){
        try{
            lock.lock();
            System.out.println(" B1线程开始时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
            conditionB.await();
            System.out.println(" B1线程结束时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void awaitB2(){
        try{
            lock.lock();
            System.out.println("B2线程开始时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
            conditionB.await();
            System.out.println("B2线程结束时间为："+System.currentTimeMillis()
                    +"当前线程名称："+Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void signalAll_A(){
        try{
            lock.lock();
            System.out.println("signalAll_A时间为："
                    +System.currentTimeMillis()
                    +"线程名字为"+Thread.currentThread().getName());
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void signalAll_B(){
        try{
            lock.lock();
            System.out.println("signalAll_B时间为："
                    +System.currentTimeMillis()
                    +"线程名字为"+Thread.currentThread().getName());
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
class Thread4A extends Thread{
    private MyService4 myService4;

    public Thread4A(MyService4 myService4) {
        this.myService4 = myService4;
    }

    @Override
    public void run() {
        myService4.awaitA1();
        myService4.awaitA2();
    }
}
class Thread4B extends Thread{
    private MyService4 myService4;

    public Thread4B(MyService4 myService4) {
        this.myService4 = myService4;
    }

    @Override
    public void run() {
        myService4.awaitB1();
        myService4.awaitB2();
    }
}
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyService4 myService4 = new MyService4();
        Thread4A a = new Thread4A(myService4);
        a.setName("A");
        a.start();
        Thread4B b = new Thread4B(myService4);
        b.setName("B");
        b.start();
        Thread.sleep(2000);
        myService4.signalAll_A();

    }
}
/*
    运行结果：
    A1线程开始时间为：1558866594211当前线程名称：A
     B1线程开始时间为：1558866594215当前线程名称：B
    signalAll_A时间为：1558866596210线程名字为main
    A1线程结束时间为：1558866596210当前线程名称：A
    A2线程开始时间为：1558866596210当前线程名称：A

    结论：只有A的两个线程被唤醒了；
 */