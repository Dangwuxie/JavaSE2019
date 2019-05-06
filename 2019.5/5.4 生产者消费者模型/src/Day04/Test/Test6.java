package Day04.Test;
//张  视频代码

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class Producer6 implements Runnable{

    //写一个队列放商品,容器，生产者跟消费者要共享一个容器，
    // 所以这里要传一个容器过来
    private final Queue<Goods6> goodsQuene;
    //还得有个限制，容器商品得限制
    private final Integer maxGoods;
    //给商品起个编号
    private final AtomicInteger goodsId = new AtomicInteger(0);
    Producer6(Queue<Goods6> goodsQuene, Integer maxGoods) {
        this.goodsQuene = goodsQuene;
        this.maxGoods = maxGoods;
    }
    @Override
    public void run() {
        //生产物品往池子里面放
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.goodsQuene){
                if (this.goodsQuene.size() >= maxGoods){
                    try {
                        System.out.println(Thread.currentThread().getName()
                                +"商品队列已经满了，等待消费");
                        this.goodsQuene.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {

                    Goods6 goods6 = new Goods6("商品"
                            +goodsId.getAndIncrement(),Math.random());
                    this.goodsQuene.add(goods6);
                    System.out.println(Thread.currentThread().getName()
                            +"商品队列未满，生产继续"+ goods6);
                }
            }

        }
    }
}

class Consumer6 implements Runnable{
    final Queue<Goods6> goods6Queue;
    public Consumer6(Queue<Goods6> goods6Queue) {
        this.goods6Queue = goods6Queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.goods6Queue){
                if (this.goods6Queue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()
                            +"商品队列已空  通知生产--");
                    this.goods6Queue.notify();
                }else {

                    Goods6 goods6 = this.goods6Queue.poll();
                    if (goods6 != null){
                        //有可能是null，并发得必须判断一下；
                        System.out.println(Thread.currentThread().getName()
                                +"商品队列有货  消费商品"+goods6);
                    }
                }
            }
        }
    }
}

class Goods6{
    //商品名称
    private String goodsName;
    //商品价格
    private double price;

    public Goods6(String goodsName, double price) {
        this.goodsName = goodsName;
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    @Override
    public String toString() {
        return "{商品名字 = " + goodsName +", 价格 = " + price + "}";
    }
}
public class Test6 {
    public static void main(String[] args) {
        //主方法里面测试
        //一个生产者、一个消费者
        //先写一个共享得商品容器
        final Queue<Goods6> queue = new LinkedList<>();
        final Integer maxGoods = 10;
        final Producer6 producer6 = new Producer6(queue,maxGoods);
        final Consumer6 consumer6 = new Consumer6(queue);
        Thread producerThread = new Thread(producer6,"生产者");
        Thread comsumerThread = new Thread(consumer6,"消费者");
        producerThread.start();
        comsumerThread.start();

    }
}
