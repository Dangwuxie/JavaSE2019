package Day13.Test.atomicIntegerNoSafe;

import java.util.concurrent.atomic.AtomicLong;

class MyService{
    public static AtomicLong aiRef = new AtomicLong();

    /**
     * 如果此方法不加synchronized，会打印顺序错误，
     * 因为addAndGetff是原子的，但方法和方法之间的
     * 调用却不是原子的，解决这样的问题必须要同步；
     */
    synchronized public void addNum(){
        System.out.println(Thread.currentThread().getName()
                +"加了100之后的值是："+aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}
class MyThread4 implements Runnable{
    private MyService myService;

    public MyThread4(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.addNum();
    }
}
public class Test4 {
    public static void main(String[] args) {
        try {
            MyService myService = new MyService();
            Thread[] threads = new Thread[5];
            for (int i = 0;i <threads.length;i++){
                threads[i] = new Thread(new MyThread4(myService));
            }
            for (int i = 0;i < threads.length;i++){
                threads[i].start();
            }
            Thread.sleep(1000);
            System.out.println(myService.aiRef.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
