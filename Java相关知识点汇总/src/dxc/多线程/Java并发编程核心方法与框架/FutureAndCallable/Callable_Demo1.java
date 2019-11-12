package dxc.多线程.Java并发编程核心方法与框架.FutureAndCallable;

import java.util.concurrent.*;

/**
 * @author 灵魂编程者
 * @Title: Callable_Demo1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 17:11
 */

/*
*使用Future对象接收Callable线程执行完之后返回的Future对象，
* get获得返回的信息；
* */
public class Callable_Demo1 {

    public static void main(String[] args) throws InterruptedException {

        try {
            MyCallable myCallable = new MyCallable(666);

            ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,4
                    ,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            Future<String> future = executor.submit(myCallable);

            System.out.println("线程 A："+System.currentTimeMillis());
            System.out.println(future.get());
            System.out.println("线程 B："+System.currentTimeMillis());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/*
*
    线程 A：1573465108138
    返回值年龄是：666
    线程 B：1573465113140
* */
