package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 灵魂编程者
 * @Title: ThreadPoolExecutor_4
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 16:07
 */

/*
* 当execute()方法将要执行的线程数量>maximumPoolSize的时候
* 1、使用LinkedBlockingDeque队列的时候
*   当使用LinkedBlockingDeque队列的时候，多于核心线程数的线程会放入队列中等待执行
* 2、使用SynchronousQueue的时候
* */
public class ThreadPoolExecutor_4 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()
                            +"开始运行"+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(5,7,3
                ,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());*/

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,7,3
                ,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        executor.execute(runnable);

        Thread.sleep(200);
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());

        Thread.sleep(4000);
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());


    }
}
/*
* 当使用LinkedBlockingDeque队列的时候，多于核心线程数的线程会放入队列中等待执行
*
*   pool-1-thread-1开始运行1573460145167
    pool-1-thread-2开始运行1573460145168
    pool-1-thread-3开始运行1573460145168
    pool-1-thread-4开始运行1573460145168
    pool-1-thread-5开始运行1573460145168
    5
    5
    4
    pool-1-thread-3开始运行1573460146168
    pool-1-thread-5开始运行1573460146168
    pool-1-thread-1开始运行1573460146168
    pool-1-thread-4开始运行1573460146168
    5
    5
    0
* */

/*
* 当使用SynchronousQueue队列的时候，如果executor()方法将要执行的线程数量超过了最大线程数
* 那么仅执行maximumPoolSize的线程，其他任务不再处理抛出异常
*
* Exception in thread "main" java.util.concurrent.RejectedExecutionException:
* Task dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor.
* ThreadPoolExecutor_4$1@7ea987ac rejected from java.util.concurrent.
* ThreadPoolExecutor@12a3a380[Running, pool size = 7, active threads = 7,
* queued tasks = 0, completed tasks = 0]
	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
	at dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor.ThreadPoolExecutor_4.main(ThreadPoolExecutor_4.java:52)
*
* pool-1-thread-1开始运行1573460496504
pool-1-thread-2开始运行1573460496504
pool-1-thread-3开始运行1573460496504
pool-1-thread-4开始运行1573460496504
pool-1-thread-5开始运行1573460496505
pool-1-thread-6开始运行1573460496505
pool-1-thread-7开始运行1573460496505
*
* */