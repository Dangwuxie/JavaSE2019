package Day28.Test;
//锁主代码块，同步代码块；
class MyThread2 implements Runnable{
    private int ticket = 30;

    @Override
    public void run() {
        for (int i = 0;i < 30;i++){
            //在同一时刻，只允许一个线程进入代码块进行处理；
            synchronized (this){
                if (this.ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+
                            "，还有"+this.ticket--+"张票");
                }
            }
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        Thread t1 = new Thread(mt,"黄牛A");
        Thread t2 = new Thread(mt,"黄牛B");
        Thread t3 = new Thread(mt,"黄牛C");

        t1.start();
        t2.start();
        t3.start();
    }
}
