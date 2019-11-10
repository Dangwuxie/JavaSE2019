package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 灵魂编程者
 * @Title: ThreadPoolExecutor_1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/29 16:36
 */
/*
* 适用ThreadPoolExecutor构造方法创建线程池；其中可以传入参数
* */
public class ThreadPoolExecutor_1 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                7,8,5,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>());


        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getMaximumPoolSize());

        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(
                7,8,5,
                TimeUnit.SECONDS,new SynchronousQueue<>());
        System.out.println(executor2.getCorePoolSize());
        System.out.println(executor2.getMaximumPoolSize());

    }
}
