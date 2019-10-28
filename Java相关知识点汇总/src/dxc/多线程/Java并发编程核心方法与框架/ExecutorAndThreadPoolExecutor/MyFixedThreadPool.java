package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 灵魂编程者
 * @Title: MyFixedThreadPool
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/28 20:28
 */

/*
* 使用newFixedThreadPool创建有界线程池；
* 有界就是可以限制线程池创建的线程个数；
* */


public class MyFixedThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0;i<3;i++){
            executorService.execute(new MyRunnable(" "+(i+1)));
        }

        for (int i=0;i<3;i++){
            executorService.execute(new MyRunnable(" "+(i+1)));
        }

    }
}
