package Day20.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * void lockInterruptibly()：
 * 作用是如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常；
 */
class MyService17 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void myServiceMethod(){
        try{
            lock.lockInterruptibly();
            System.out.println("开始锁：当前线程名称为："
                    +Thread.currentThread().getName());
            for (int i = 0;i < Integer.MAX_VALUE / 10;i++){
                String newString = new String();
                Math.random();
            }
            System.out.println("结束锁：当前线程名称为："
                    +Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("B线程进入了catch块");
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }
}
public class Test17 {
    public static void main(String[] args)
            throws InterruptedException {
        final MyService17 myService17 = new MyService17();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myService17.myServiceMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
        threadB.interrupt();
        System.out.println("Main方法结束；");
    }
}
/*
    运行结果：

    开始锁：当前线程名称为：A
    Main方法结束；
    结束锁：当前线程名称为：A
    开始锁：当前线程名称为：B
    结束锁：当前线程名称为：B
 */