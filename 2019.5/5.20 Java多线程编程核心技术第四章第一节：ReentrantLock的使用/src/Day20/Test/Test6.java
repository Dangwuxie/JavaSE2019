package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition实现生产者/消费者模式：
 * 一对一交替打印;
 */
class MyService6{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try{
            lock.lock();
            while (hasValue == true){
                condition.await();
            }
            Thread.sleep(500);
            System.out.println("打印A");
            hasValue = true;
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void get(){
        try{
            lock.lock();
            while (hasValue == false){
                condition.await();
            }
            Thread.sleep(500);
            System.out.println("打印B");
            hasValue = false;
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class Thread6A extends Thread{
    private MyService6 myService6;

    public Thread6A(MyService6 myService6) {
        this.myService6 = myService6;
    }

    @Override
    public void run() {
        while(true){
            myService6.set();
        }
    }
}

class Thread6B extends Thread{
    private MyService6 myService6;

    public Thread6B(MyService6 myService6) {
        this.myService6 = myService6;
    }

    @Override
    public void run() {
        while(true){

            myService6.get();
        }
    }
}
public class Test6 {
    public static void main(String[] args) {
        MyService6 myService6 = new MyService6();
        Thread6A thread6A = new Thread6A(myService6);
        thread6A.start();
        Thread6B thread6B = new Thread6B(myService6);
        thread6B.start();

    }
}
