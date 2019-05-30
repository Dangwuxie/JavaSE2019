package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现多对多生产者消费者模式；
 * 多对多交替打印；
 */

class MyService7{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try{
            lock.lock();
            while (hasValue == true){
                System.out.println("有可能 A  连续");
                condition.await();
            }
            System.out.println("打印 A");
            hasValue = true;
            condition.signalAll();
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
                System.out.println("有可能 B  连续");
                condition.await();
            }
            System.out.println("打印 B");
            hasValue = false;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class Thread7A extends Thread{
    private MyService7 myService7;

    public Thread7A(MyService7 myService7) {
        this.myService7 = myService7;
    }

    @Override
    public void run() {
        while(true){
            myService7.set();
        }
    }
}

class Thread7B extends Thread{
    private MyService7 myService7;

    public Thread7B(MyService7 myService7) {
        this.myService7 = myService7;
    }

    @Override
    public void run() {
        while(true){
            myService7.get();
        }
    }
}
public class Test7 {
    public static void main(String[] args) {
        MyService7 myService7 = new MyService7();
        Thread7A[] thread7AS = new Thread7A[5];
        Thread7B[] thread7BS = new Thread7B[5];
        for (int i = 0;i < 5;i++){
            thread7AS[i] = new Thread7A(myService7);
            thread7BS[i] = new Thread7B(myService7);
            thread7AS[i].start();
            thread7BS[i].start();
        }
    }
}
/*
        打印结果：

        打印 A
        有可能 A  连续
        有可能 A  连续
        打印 B
        有可能 B  连续
        打印 A
        有可能 A  连续
        有可能 A  连续
        有可能 A  连续
        打印 B
        有可能 B  连续
        有可能 B  连续
        有可能 B  连续
        有可能 B  连续


        出现这种“有可能 B  连续”、“有可能 A  连续”
        打印的情况就是因为程序中使用了一个Condition对象，
        再结合signalAll()方法来唤醒所有的线程，
        那么唤醒的线程就有可能是同类，所以就出现了这种情况；
 */