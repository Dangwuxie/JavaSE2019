package Day14.Test;

class MyThread2 extends Thread{
    private String name;
    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(this.name+", i ="+ i);
        }
    }
}
public class Test2 {

    public static void main(String[] args) {
        MyThread2 myThread1 = new MyThread2("线程1");
        MyThread2 myThread2 = new MyThread2("线程2");
        MyThread2 myThread3 = new MyThread2("线程3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}