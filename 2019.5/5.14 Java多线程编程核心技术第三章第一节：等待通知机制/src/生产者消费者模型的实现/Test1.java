package 生产者消费者模型的实现;

import java.util.ArrayList;
import java.util.List;

/**
 * 一生产一消费：操作值
 */
//商品
class ValueObject{
    public static String value = "Apple";
}
//生产者
class P{
    private String lock;
    public P(String lock){
        this.lock = lock;
    }
    public void setValue(){
        try{
            synchronized (lock){
                if (!ValueObject.value.equals("Apple")){
                    System.out.println(Thread.currentThread().getName()+"有一个商品了，等待消费------");
                    lock.wait();

                }
                Thread.sleep(500);
                String value = "Apple";
                ValueObject.value = value;
                System.out.println(Thread.currentThread().getName()+"生产者当前的value的值是："+ValueObject.value);
                lock.notify();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
//消费者
class C{
    private String lock;
    public C(String lock) {
        this.lock = lock;
    }
    public void getValue(){
        try{
            synchronized (lock){
                if (ValueObject.value.equals("null")){
                    System.out.println(Thread.currentThread().getName()+"没有商品了，等待生产-----");
                    lock.wait();
                }
                Thread.sleep(1000);
                ValueObject.value = "null";
                System.out.println(Thread.currentThread().getName()+"消费者当前的value的值是："+ValueObject.value);
                lock.notify();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
//定义两个线程
class Thread1P implements Runnable{
    private P p;

    public Thread1P(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.setValue();
    }
}
class Thread1C implements Runnable{
    private C c;

    public Thread1C(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.getValue();
    }
}
public class Test1 {
    public static void main(String[] args) {
        String lock = new String();
        P p = new P(lock);
        C c = new C(lock);

    }
}
