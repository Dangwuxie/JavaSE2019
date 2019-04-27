package Day14.Test;
//下面使用继承Runnable接口来实现卖票的情况，总共十张票，三个人卖；
class MyThread7 implements Runnable{
    //private String name;
    private Integer ticket = 10;
    @Override
    public void run() {
        while(ticket > 0){
            System.out.println(Thread.currentThread().getName()
                    +"剩余票数："+ticket--);
        }
    }
}
public class Test7 {
    public static void main(String[] args) {
        MyThread7 myThread1 = new MyThread7();
        new Thread(myThread1,"A").start();
        new Thread(myThread1,"B").start();
        new Thread(myThread1,"C").start();
    }
}
