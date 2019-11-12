package dxc.多线程.Java并发编程核心方法与框架.FutureAndCallable;

import java.util.concurrent.*;

/**
 * @author 灵魂编程者
 * @Title: Callable_Demo2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 18:22
 */
public class Callable_Demo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable要打印的信息");
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,3,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        Future future = executor.submit(myRunnable);
        System.out.println(future.get());
        System.out.println(future.isDone());
    }
}
