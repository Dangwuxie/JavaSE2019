package Day06.Test;

import java.util.concurrent.*;

class MyThread3 implements Runnable {
    @Override
    public void run(){
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
    }
}
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        //使用固定大小的线程池，内置的线程池
        MyThread3 myThread3 = new MyThread3();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0;i < 5;i++){
            Thread.sleep(100);
            executorService.submit(myThread3);
        }
        executorService.shutdown();
    }
}
