package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 灵魂编程者
 * @Title: ThreadPoolExecutor_3
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 0:09
 */

/*
* 在线程池中添加的线程数量>corePoolSize,但是<=maximumPoolSize；
* 线程池分别使用LinkedBlockingDeque队列和SynchronousQueue队列
*  1、使用LinkedBlockingDeque队列时候会将多余核心线程数量的线程放入阻塞队列中，等待执行
*  2、使用SynchronousQueue的时候会直接创建线程来执行这些任务，
*  也就是说当前线程池允许运行的线程数量个数就是当前需要执行的线程数；
*  执行超出任务后，如果超出KeepAliveTime的时间限制，就会回收超过核心线程数的任务线程
* */
public class ThreadPoolExecutor_3 {
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

        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(7,9,5
                ,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());*/

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,9,2
                ,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
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
        System.out.println(executor.getPoolSize());//获得的是execute方法要执行的Runnable线程数的个数
        System.out.println(executor.getQueue().size());
        Thread.sleep(4000);
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());


    }
}

/*
*
*   LinkedBlockingDeque队列使用的结果
*   pool-1-thread-1开始运行1573403547889
    pool-1-thread-2开始运行1573403547890
    pool-1-thread-4开始运行1573403547891
    pool-1-thread-3开始运行1573403547891
    pool-1-thread-5开始运行1573403547891
    pool-1-thread-6开始运行1573403547891
    pool-1-thread-7开始运行1573403547892
    7
    7
    1
    pool-1-thread-1开始运行1573403548891
    7
    7
    0
* */

/*
*
*   pool-1-thread-1开始运行1573459346206
    pool-1-thread-2开始运行1573459346209
    pool-1-thread-3开始运行1573459346209
    pool-1-thread-4开始运行1573459346209
    pool-1-thread-5开始运行1573459346210
    pool-1-thread-6开始运行1573459346210
    pool-1-thread-7开始运行1573459346211
    pool-1-thread-8开始运行1573459346211
    7
    8
    0
    7
    7
    0
* */