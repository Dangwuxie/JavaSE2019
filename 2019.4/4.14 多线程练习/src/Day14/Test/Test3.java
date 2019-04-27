package Day14.Test;
//2.2、Runnable接口实现多线程；
//启动多线程，通过Tread类中的构造方法来启动
class MyThread3 implements Runnable{
    private String name;
    public MyThread3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(this.name+", i ="+ i);
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        MyThread3 myThread1 = new MyThread3("线程1");
        MyThread3 myThread2 = new MyThread3("线程2");
        MyThread3 myThread3 = new MyThread3("线程3");
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();
    }
}
