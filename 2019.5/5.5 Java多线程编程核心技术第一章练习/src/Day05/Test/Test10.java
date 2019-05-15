package Day05.Test;
//suspend方法与println之间存在的问题；
class MyThread10 implements Runnable{
    private long i = 0;
    @Override
    public void run() {
        while(true){
            i++;
            System.out.println(i);
        }
    }
}

public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        MyThread10 m10 = new MyThread10();
        Thread t1 = new Thread(m10);
        t1.start();
        Thread.sleep(500);
        t1.suspend();
        System.out.println("main end");
    }
}
