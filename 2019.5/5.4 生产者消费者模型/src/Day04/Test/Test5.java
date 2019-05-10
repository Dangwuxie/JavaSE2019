package Day04.Test;
//修改test4的代码，使得开启生产者线程和消费者线程的
// 代码位置不同时不会出现消费数量的错误显示

class Goods5{
    private String goodsName;
    private int count;

    //生产方法
    public synchronized void set(String goodsName) throws InterruptedException {
        //先判断此时有没有商品被消费，等待消费者消费
        if (this.count > 0){
            System.out.println("还有库存，等待消费----");
            wait();
        }
        this.goodsName = goodsName;
        this.count = count+1;
        Thread.sleep(2000);
        System.out.println("生产"+toString());
        //生产完商品后通知消费者可以消费了
        notify();//唤醒消费者
    }

    //消费方法

    public synchronized void get() throws InterruptedException {
        //先判断此时有没有商品，没有的话等待生产
        if (this.count <= 0){
            System.out.println("现在没有商品，等待生产----");
            Thread.sleep(1000);
            wait();
        }

        this.count = this.count-1;
        Thread.sleep(2000);
        System.out.println("消费"+toString());
        //消费完后通知生产者生产；
        notify();
    }
    @Override
    public String toString() {
        return "{GoodsName = " + goodsName
                +", count = " + count + "}";
    }
}

class Producer5 implements Runnable{
    private Goods5 goods5;
    public Producer5(Goods5 goods5) {
        this.goods5 = goods5;
    }
    @Override
    public void run() {
        try {
            this.goods5.set("奔驰");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer5 implements Runnable{
    private Goods5 goods5;

    public Consumer5(Goods5 goods5) {
        this.goods5 = goods5;
    }
    @Override
    public void run() {
        try {
            this.goods5.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test5 {
    public static void main(String[] args) {
        Goods5 goods5 = new Goods5();
        Thread producerThread = new Thread(new Producer5(goods5),"生产者线程");
        Thread consumerThread = new Thread(new Consumer5(goods5),"消费者线程");

        consumerThread.start();
        producerThread.start();
    }
}
