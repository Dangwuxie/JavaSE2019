package Day16.Test;

class MyThread implements Runnable{
    private int ticket = 10;
    @Override
    public void run(){
        while(this.ticket > 0){
            synchronized (this){
                if (this.ticket > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+
                            "还剩下"+this.ticket--+"票");
                }
            }
        }
    }
}
public class Test1 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt,"黄牛A");
        Thread thread2 = new Thread(mt,"黄牛B");
        Thread thread3 = new Thread(mt,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
