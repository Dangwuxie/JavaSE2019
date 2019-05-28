package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition实现等待/通知：
 * 以等待一唤醒；
 */

class MyService3{
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void await(){
        try{
            lock.lock();
            System.out.println("await时间为："+System.currentTimeMillis());
            condition.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void signal(){
        try{
            lock.lock();
            System.out.println("signal时间为："+System.currentTimeMillis());
            condition.signal();

        }finally {
            lock.unlock();
        }
    }
}
class  Thread3A extends Thread{
    private MyService3 myService3;

    public Thread3A(MyService3 myService3) {
        this.myService3 = myService3;
    }

    @Override
    public void run() {
        myService3.await();
    }
}
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        MyService3 myService3 = new MyService3();
        Thread3A thread3A = new Thread3A(myService3);
        thread3A.start();
        Thread.sleep(2000);
        myService3.signal();
    }
}
/*
    运行结果：

    await时间为：1558864387372
     signal时间为：1558864389372
 */