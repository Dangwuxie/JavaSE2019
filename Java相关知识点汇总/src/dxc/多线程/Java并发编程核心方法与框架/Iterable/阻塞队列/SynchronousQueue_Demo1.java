package dxc.多线程.Java并发编程核心方法与框架.Iterable.阻塞队列;

import java.util.concurrent.SynchronousQueue;

/**
 * @author 灵魂编程者
 * @Title: SynchronousQueue_Demo1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 16:10
 */
/*
* 验证异步队列SynchronousQueue的使用
*
* */

class MyService{
    public static SynchronousQueue queue = new SynchronousQueue();

    public void putMethod(){
        try{
            String putString = "字符串"+Math.random();
            System.out.println("put = "+putString);
            queue.put(putString);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void takeMethod(){
        try {
            System.out.println("take = "+queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadPut extends Thread{
    private MyService service;

    public ThreadPut(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            service.putMethod();
        }
    }
}
class ThreadTake extends Thread{
    private MyService service;

    public ThreadTake(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            service.takeMethod();
        }
    }
}

public class SynchronousQueue_Demo1 {

    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();
        ThreadPut threadPut = new ThreadPut(myService);
        ThreadTake threadTake = new ThreadTake(myService);

        threadPut.start();
        Thread.sleep(1000);
        threadTake.start();

        /*
        SynchronousQueue queue = new SynchronousQueue();
        System.out.println(1);
        queue.put(1);
        System.out.println(2);
        System.out.println(queue.take());
        System.out.println(3);*/

    }
}
