package Day01.Test;
//synchronized加到方法上
class MyThread4 implements Runnable{
    private int ticket = 20;

    @Override
    public synchronized void run() {
        while (this.ticket > 0){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        +"买票  剩余"+--this.ticket+"张");
                if (this.ticket == 0){
                    System.out.println("票卖完了。。。");
                }
        }
    }
}
public class Test4 {
    public static void main(String[] args) {
        Runnable myThread2 = new MyThread4();
        Thread thread1 = new Thread(myThread2,"黄牛A");
        Thread thread2 = new Thread(myThread2,"黄牛B");
        Thread thread3 = new Thread(myThread2,"黄牛C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
