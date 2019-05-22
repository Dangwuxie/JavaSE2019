package Day14.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 等待wait的条件发生变化；
 *
 */
class ValueObject{
    public static List list = new ArrayList();
}
//加法操作
class Add{
    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }
    public void add(){
        synchronized (lock){
            while (ValueObject.list.size() == 0){
                ValueObject.list.add("anything");
                lock.notifyAll();
            }
        }
    }
}
//减法操作
class Subtract{
    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }
    public void subtract(){
           try {
               synchronized (lock){
                   while (ValueObject.list.size() == 0){
                       System.out.println("线程"+Thread.currentThread().getName()+"开始等待列表添加元素-----");
                       lock.wait();
                       System.out.println("线程"+Thread.currentThread().getName()+"等待结束，开始减法操作");
                   }
                   ValueObject.list.remove(0);
                   System.out.println("集合的长度为："+ValueObject.list.size());
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

    }
}
//定义两个线程
class Thread6A implements Runnable{
    private Add add;

    public Thread6A(Add add) {
        this.add = add;
    }

    @Override
    public void run() {
        add.add();
    }
}
class Thread6B implements Runnable{
    private Subtract subtract;

    public Thread6B(Subtract subtract) {
        this.subtract = subtract;
    }

    @Override
    public void run() {
        subtract.subtract();
    }
}
public class Test6 {
    public static void main(String[] args) {
        String lock = new String(" ");
        Add add = new Add(lock);
        Subtract sub = new Subtract(lock);
        Thread addThread1 = new Thread(new Thread6A(add));
        Thread subThread1 = new Thread(new Thread6B(sub));
        Thread subThread2 = new Thread(new Thread6B(sub));
        subThread1.start();
        subThread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addThread1.start();
    }
}
