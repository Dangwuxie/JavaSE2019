package Day24.Test;
//线程休眠
class MyThread3 extends Thread{
    private int ticket2 = 10;
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+
                    "还剩下"+this.ticket2--+"票");
        }
    }
}
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main方法开始---");
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        Thread.sleep(2000);
        System.out.println("main方法结束---");
    }
}
