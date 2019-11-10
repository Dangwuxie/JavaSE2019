package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 灵魂编程者
 * @Title: ThreadPoolExecutor_2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/10 17:29
 */
/*
* 实验在线程池中添加的线程数量<=corePoolSize
* */
public class ThreadPoolExecutor_2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()
                            +"开始运行"+System.currentTimeMillis());
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>());*/
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,5,
                TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());

    }
}
/*
*   pool-1-thread-1开始运行1573380790432
    pool-1-thread-2开始运行1573380790433
    pool-1-thread-3开始运行1573380790433
    pool-1-thread-5开始运行1573380790433
    pool-1-thread-4开始运行1573380790434
    pool-1-thread-6开始运行1573380790434
    pool-1-thread-7开始运行1573380790434
    7
    7
    0
    7
    7
    0
* */