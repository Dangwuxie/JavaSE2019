package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 灵魂编程者
 * @Title: ThreadPoolExecutor_5
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 16:34
 */

/*
* 当keepAliveTime为0的时候,
* 使用的队列是SynchronousQueue的话，当超过corePoolSize的任务执行完之后
* 立即删除不在corePoolSize里面的线程；
*
*
* */
public class ThreadPoolExecutor_5 {

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

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,7,0,
                TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
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
