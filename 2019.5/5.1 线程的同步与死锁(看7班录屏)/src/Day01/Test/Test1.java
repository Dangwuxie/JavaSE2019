package Day01.Test;
//卖票解决多个线程同时竞争资源的情况；
//模拟网络延时；
class MyThread1 implements Runnable{
    private int ticket = 30;

    @Override
    public void run() {
        while (this.ticket > 0){
            synchronized (this){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"买票  剩余"+--this.ticket+"张");
            }
            }
        System.out.println("票卖完了");
    }
}

public class Test1 {

    public static void main(String[] args) {
        Runnable myThread1 = new MyThread1();
        Thread thread1 = new Thread(myThread1,"黄牛A");
        Thread thread2 = new Thread(myThread1,"黄牛B");
        Thread thread3 = new Thread(myThread1,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
