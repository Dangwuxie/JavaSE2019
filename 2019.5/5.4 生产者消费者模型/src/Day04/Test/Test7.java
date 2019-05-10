package Day04.Test;
//修改test4的代码，使得开启生产者线程和消费者线程的
// 代码位置不同时不会出现消费数量的错误显示

import java.util.LinkedList;
import java.util.List;

class Goods7{
    private String goodsName;
    private int count;

    //生产方法
    public synchronized void set(String goodsName) throws InterruptedException {
        //先判断此时有没有商品被消费，等待消费者消费
        while (this.count > 0){
            System.out.println("还有库存，等待消费----");
            wait();
        }
        this.goodsName = goodsName;
        this.count = count+1;
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName()+"生产"+toString());
        //生产完商品后通知消费者可以消费了
        notifyAll();//唤醒消费者
    }

    //消费方法

    public synchronized void get() throws InterruptedException {
        //先判断此时有没有商品，没有的话等待生产
        while (this.count == 0){
            System.out.println("现在没有商品，等待生产----");
            wait();
        }

        this.count = this.count-1;
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName()+"消费"+toString());
        //消费完后通知生产者生产；
        notifyAll();
    }
    @Override
    public String toString() {
        return "{GoodsName = " + goodsName
                +", count = " + count + "}";
    }
}

class Producer7 implements Runnable{
    private Goods7 goods7;
    public Producer7(Goods7 goods5) {
        this.goods7 = goods5;
    }
    @Override
    public void run() {
        while (true){
            try {
                this.goods7.set("奔驰");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer7 implements Runnable{
    private Goods7 goods7;

    public Consumer7(Goods7 goods7) {
        this.goods7 = goods7;
    }
    @Override
    public void run() {
        while (true){
            try {
                this.goods7.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Test7 {
    public static void main(String[] args) {
        Goods7 goods7 = new Goods7();
        List<Thread> list = new LinkedList<>();


        for (int i = 0;i <3;i++){
            Thread producerThread = new Thread(new Producer7(goods7),"生产者线程"+i);
            list.add(producerThread);
        }
        for (int i = 0;i<5;i++){
            Thread consumerThread = new Thread(new Consumer7(goods7),"消费者线程"+i);
            list.add(consumerThread);
        }

        for (Thread e : list){
            e.start();
        }
    }
}
