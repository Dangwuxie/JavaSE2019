package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 灵魂编程者
 * @Title: MySinglePool
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/28 20:41
 */

/*
* 使用newSingleThreadExexutor()方法创建单一线程池；
*
* */


public class MySinglePool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i=0;i<3;i++){
            executorService.execute(new MyRunnable(" "+(i+1)));
        }
    }
}
/*
* 运行结果：
* pool-1-thread-1 username= 1 begin 1572267075633
 pool-1-thread-1 username= 1 end 1572267077635
 pool-1-thread-1 username= 2 begin 1572267077635
 pool-1-thread-1 username= 2 end 1572267079636
 pool-1-thread-1 username= 3 begin 1572267079636
 pool-1-thread-1 username= 3 end 1572267081637
* */