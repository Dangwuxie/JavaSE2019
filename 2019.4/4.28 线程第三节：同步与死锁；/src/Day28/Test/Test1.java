package Day28.Test;
//同步问题的查看；继续卖票；

class MyThread1 implements Runnable{
    private int ticket = 10;

    @Override
    public void run() {
        while(this.ticket > 0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + "，还有"+this.ticket--+"张票");
        }
    }
}
public class Test1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        new Thread(myThread1,"黄牛A").start();
        new Thread(myThread1,"黄牛B").start();
        new Thread(myThread1,"黄牛C").start();
    }
}
