package Day28.Test;
//同步方法，锁住方法；
class MyThread3 implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        for (int i = 0;i < 10;i++ ){
            this.sale();
        }
    }
    public synchronized void sale(){
        if (this.ticket > 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    "，还有"+this.ticket--+"张票");
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        MyThread3 mt = new MyThread3();
        Thread t1 = new Thread(mt,"黄牛A");
        Thread t2 = new Thread(mt,"黄牛B");
        Thread t3 = new Thread(mt,"黄牛C");

        t1.start();
        t2.start();
        t3.start();
    }
}
