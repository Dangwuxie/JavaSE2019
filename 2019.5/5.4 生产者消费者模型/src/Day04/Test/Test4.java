package Day04.Test;
//一个生产者一个消费者；
//这种
class Goods{
    //商品名称
    private String goodsName;
    //商品库存；
    private int count;
    //生产方法
    public synchronized void set(String goodsName){
        this.goodsName = goodsName;
        this.count = this.count+1;
        System.out.println(toString());
    }
    //消费方法；
    public synchronized void get(){
        //每次消费一个产品
        this.count = this.count-1;
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "{GoodsName = " + goodsName
                +", count = " + count + "}";
    }
}
//生产者
class Producer implements Runnable{
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.set("气球");
    }
}
//消费者；
class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.get();
    }
}


public class Test4 {
    public static void main(String[] args) {
        Goods goods = new Goods();
        Thread produceThread = new Thread(new Producer(goods),"生产者线程");
        Thread consumerThread = new Thread(new Consumer(goods),"消费者线程");
        //启动生产者线程

        produceThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumerThread.start();
    }
}
