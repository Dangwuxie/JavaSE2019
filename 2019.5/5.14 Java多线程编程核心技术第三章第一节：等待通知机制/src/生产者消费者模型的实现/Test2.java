package 生产者消费者模型的实现;

import java.util.ArrayList;
import java.util.List;

/**
 * 多生产与多消费
 * 操作值：假死；
 */
//商品
class ValueGoods2{
    public static String value = "Apple";
}
//生产者
class P2{
    private String lock;

    public P2(String lock) {
        this.lock = lock;
    }
    public void setValue(){
        while (true){
            try{
                synchronized (lock){
                    while (ValueObject.value.equals("Apple")){
                        System.out.println(Thread.currentThread().getName()+"已经有东西了，等待消费者生产----");
                        lock.wait();
                    }
                    Thread.sleep(1000);
                    ValueObject.value = "Apple";
                    System.out.println(Thread.currentThread().getName()+"生产"+ValueGoods2.value);
                    lock.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
//消费者
class C2{
    private String lock;

    public C2(String lock) {
        this.lock = lock;
    }
    public void getValue(){
        while (true){
            try{
                synchronized (lock){
                    while (ValueObject.value.equals(" ")){
                        System.out.println(Thread.currentThread().getName()+"等待生产者生产");
                        lock.wait();
                    }
                    Thread.sleep(2000);
                    ValueObject.value = " ";
                    System.out.println(Thread.currentThread().getName()+"消费"+ValueGoods2.value);
                    lock.notifyAll();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class ThreadP2 implements Runnable{
    private P2 p;

    public ThreadP2(P2 p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.setValue();
    }
}
class ThreadC2 implements Runnable{
    private C2 c;

    public ThreadC2(C2 c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.getValue();
    }
}
public class Test2 {
    public static void main(String[] args) {
        List<Thread> ThreadList2 = new ArrayList<>();
        String lock = new String();
        P2 p2 = new P2(lock);
        C2 c2 = new C2(lock);
        for (int i = 0;i < 2;i++){
            ThreadList2.add(new Thread(new ThreadP2(p2)));
            ThreadList2.add(new Thread(new ThreadC2(c2)));
        }
        for (Thread o:ThreadList2){
            o.start();
        }
    }
}
