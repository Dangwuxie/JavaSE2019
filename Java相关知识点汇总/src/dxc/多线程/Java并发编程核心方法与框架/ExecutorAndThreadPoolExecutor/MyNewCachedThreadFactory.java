package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author 灵魂编程者
 * @Title: MyNewCachedThreadFactory
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/28 20:13
 */
/*
* 使用newCachedThreadPool()创建定制的线程工厂
* */

class MyThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t1 = new Thread();
        t1.setName("定制线程池的名称："+Math.random());
        return t1;
    }
}

public class MyNewCachedThreadFactory {
    public static void main(String[] args) {

        MyThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("运行名称："+" "+Thread.currentThread().getName());
            }
        });


    }
}
