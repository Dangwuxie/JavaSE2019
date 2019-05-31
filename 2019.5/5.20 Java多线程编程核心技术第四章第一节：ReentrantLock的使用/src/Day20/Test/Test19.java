package Day20.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * boolean tryLock(long timeout, TimeUnit unit)：
 * 如果锁定在给定等待时间内没有被另外一个线程保持，
 * 且当前线程未被中断，则获取该锁定；
 */

class MyService19{
    public ReentrantLock lock = new ReentrantLock();
    public void waitMethod(){
        try{
            if (lock.tryLock(3,TimeUnit.SECONDS)){
                System.out.println("    "+Thread.currentThread().getName()
                        +"获得锁的时间："+System.currentTimeMillis());
                Thread.sleep(10000);
            }else {
                System.out.println("    "
                        +Thread.currentThread().getName()
                        +"没有获得锁 ");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}

public class Test19 {
    public static void main(String[] args) {
        final MyService19 myService19 = new MyService19();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        +"调用waitMethod时间："
                        +System.currentTimeMillis());
                myService19.waitMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();

    }
}
