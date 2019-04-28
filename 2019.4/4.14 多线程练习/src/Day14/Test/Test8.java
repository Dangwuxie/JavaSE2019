package Day14.Test;
//Callable 实现多线程;

import java.util.concurrent.*;

class MyThread8 implements Callable{
    private Integer tickets = 100;

    @Override
    public Object call() throws Exception {
        while (tickets > 0){
            System.out.println(Thread.currentThread().getName()+
                    "剩余票数："+this.tickets--);
        }
        return "卖完了";
    }
}
public class Test8 {
    public static void main(String[] args) throws Exception {
        FutureTask<String> task = new FutureTask<>(new MyThread8());
        new Thread(task,"线程1").start();
        new Thread(task,"线程2").start();
        System.out.println(task.get());
    }
}
