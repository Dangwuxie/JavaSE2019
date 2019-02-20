package Day16.Test;

class MyThread2 implements Runnable{
    private int ticket = 10;
    @Override
    public void run(){
        for (int i = 0;i < 10;i++){
            sale();
        }
    }
    //表示此时只有一个线程能够进入此方法；
    //此处有一个隐式锁对象this
    public synchronized void sale(){
        if (ticket > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    "还剩下"+this.ticket--+"票");
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyThread2 mt1 = new MyThread2();
        Thread thread1 = new Thread(mt1,"黄牛A");
        Thread thread2 = new Thread(mt1,"黄牛B");
        Thread thread3 = new Thread(mt1,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
