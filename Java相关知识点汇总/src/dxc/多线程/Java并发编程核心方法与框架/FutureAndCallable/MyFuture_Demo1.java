package dxc.多线程.Java并发编程核心方法与框架.FutureAndCallable;

import java.util.concurrent.*;

/**
 * @author 灵魂编程者
 * @Title: MyFuture_Demo1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 19:25
 */
/*
* 方法cancel和isCancelled的使用
* 1、cancel，尝试取消此任务
* 2、isCancelled，如果此任务在正常执行完之前被取消，则调用此方法返回true；
* */

class MyCallable2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "张三的年龄2000";
    }
}

public class MyFuture_Demo1 {

    public static void main(String[] args) {

        try {
            MyCallable2 myCallable2 = new MyCallable2();
            ExecutorService executor = new ThreadPoolExecutor(3,4,5
                    ,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            Future<String> future = executor.submit(myCallable2);
            //get方法可以阻塞，所以走到下一步的时候可以保证任务以及执行完毕；
            //可以分别观察cancel方法和isCancelled的使用情况；
            //System.out.println(future.get());

            System.out.println(future.cancel(true)+"  "+future.isCancelled());
        } /*catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/finally {
            System.out.println("0-------------0");
        }

    }
}
