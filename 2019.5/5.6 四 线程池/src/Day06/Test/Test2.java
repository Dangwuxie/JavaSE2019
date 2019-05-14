package Day06.Test;

import java.util.concurrent.*;

class MyThread2 implements Callable{
    @Override
    public String call(){
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
        return Thread.currentThread().getName()+"执行完毕";
    }
}
public class Test2 {
    public static void main(String[] args) throws Exception{
        MyThread2 myThread2 = new MyThread2();
        ExecutorService executorService =
                new ThreadPoolExecutor(
                        3,5,2000,
                        TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        for (int i = 0;i < 5;i++){

            Future<String> futu = executorService.submit(myThread2);
            //System.out.println(futu.get());
        }
        executorService.shutdown();
    }
}
