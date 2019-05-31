package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition还可以实现指定线程唤醒用来实现顺序执行：
 */
class F{
    volatile private static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();
    public void threadATest(){
        try{
            lock.lock();
            while (nextPrintWho != 1){
                conditionA.await();
            }
            for (int i = 0;i < 3;i++){
                System.out.println("ThreadA "+ (i + 1));
            }
            nextPrintWho = 2;
            conditionB.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void threadBTest(){
        try{
            lock.lock();
            while (nextPrintWho != 2){
                conditionB.await();
            }
            for (int i = 0;i < 3;i++){
                System.out.println("ThreadB "+ (i + 1));
            }
            nextPrintWho = 3;
            conditionC.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void threadCTest(){
        try{
            lock.lock();
            while (nextPrintWho != 3){
                conditionC.await();
            }
            for (int i = 0;i < 3;i++){
                System.out.println("ThreadC "+ (i + 1));
            }
            nextPrintWho = 1;
            conditionA.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
class Thread22A extends Thread{
    private F f;

    public Thread22A(F f) {
        this.f = f;
    }

    @Override
    public void run() {
        f.threadATest();
    }
}
class Thread22B extends Thread{
    private F f;

    public Thread22B(F f) {
        this.f = f;
    }

    @Override
    public void run() {
        f.threadBTest();
    }
}
class Thread22C extends Thread{
    private F f;

    public Thread22C(F f) {
        this.f = f;
    }

    @Override
    public void run() {
        f.threadCTest();
    }
}
public class Test22 {
    public static void main(String[] args) {
        final F f = new F();
        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];
        for (int i = 0;i < 5;i++){
            aArray[i] = new Thread22A(f);
            bArray[i] = new Thread22B(f);
            cArray[i] = new Thread22C(f);
        }
        for (int i = 0;i < 5;i++){
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }
    }
}
/*
运行结果：
按照顺序依次关系对应线程；
        ThreadA 1
        ThreadA 2
        ThreadA 3
        ThreadB 1
        ThreadB 2
        ThreadB 3
        ThreadC 1
        ThreadC 2
        ThreadC 3
        ThreadA 1
        ThreadA 2
        ThreadA 3
        ThreadB 1
        ThreadB 2
        ThreadB 3
        ThreadC 1
        ThreadC 2
        ThreadC 3
 */