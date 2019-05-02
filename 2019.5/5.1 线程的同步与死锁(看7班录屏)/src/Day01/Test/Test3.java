package Day01.Test;

class MyThread3 implements Runnable{
    private int ticket = 15;

    @Override
    public void run() {
        while (this.ticket > 0){

            //进入的其他线程在这等锁；
            synchronized (this){
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //解决同步块里的计算问题；
                if (this.ticket > 0){
                    System.out.println(Thread.currentThread().getName()
                            +"买票  剩余"+--this.ticket+"张");
                    if (this.ticket == 0){
                        System.out.println("卖光了");
                    }
                }
            }
        }
        //System.out.println("票卖完了");
    }
}
public class Test3 {
    public static void main(String[] args) {
        Runnable myThread2 = new MyThread3();
        Thread thread1 = new Thread(myThread2,"黄牛A");
        Thread thread2 = new Thread(myThread2,"黄牛B");
        Thread thread3 = new Thread(myThread2,"黄牛C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
