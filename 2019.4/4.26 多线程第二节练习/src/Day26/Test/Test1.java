package Day26.Test;
//多线程的常用操作方法；
class MyThread1 implements Runnable{
    private Integer tickets = 20;

    @Override
    public void run() {
        while(tickets > 0){
            System.out.println("当前线程："+Thread.currentThread().getName() +" 票数："+ tickets--);
        }
    }
}
public class Test1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        /*new Thread(myThread1,"线程1").start();
        new Thread(myThread1).start();
        new Thread(myThread1).start();*/
        Thread thread = new Thread(myThread1);
        thread.setName("牛皮");
        thread.start();

    }
}
