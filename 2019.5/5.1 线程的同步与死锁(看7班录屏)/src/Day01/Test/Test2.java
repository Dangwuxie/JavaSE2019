package Day01.Test;

class MyThread2 implements Runnable{
    private int ticket = 15;

    @Override
    public void run() {
        while (this.ticket > 0){
            //同步代码
            synchronized (this){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        +"买票  剩余"+--this.ticket+"张");
            }

        }
        System.out.println("票卖完了");
    }
}
public class Test2 {
    public static void main(String[] args) {
        Runnable myThread2 = new MyThread2();
        Thread thread1 = new Thread(myThread2,"黄牛A");
        Thread thread2 = new Thread(myThread2,"黄牛B");
        Thread thread3 = new Thread(myThread2,"黄牛C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
