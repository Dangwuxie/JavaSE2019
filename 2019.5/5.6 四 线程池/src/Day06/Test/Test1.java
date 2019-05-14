package Day06.Test;
//手工创建线程池
import java.util.concurrent.*;

class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
    }
}
public class Test1 {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        ExecutorService executorService =
                new ThreadPoolExecutor(
                        3,5,2000,
                        TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());

        for (int i = 0;i < 5;i++){
            executorService.execute(myThread1);
        }
    }
}
