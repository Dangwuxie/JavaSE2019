package dxc.多线程.Java并发编程核心方法与框架.Iterable.非阻塞队列;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author 灵魂编程者
 * @Title: ConcurrentHashMap_Demo2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 14:05
 */

/*
* 验证类Hashtable是否线程安全
*
* */

class MyService2{
    public Hashtable map = new Hashtable();
}

class Thread2A extends Thread{
    private MyService2 myService2;

    public Thread2A(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        for (int i=0;i<50000;i++){
            myService2.map.put("线程A"+(i+1),"线程A"+i+1);
            System.out.println("线程A"+(i+1));
        }
    }
}

class Thread2B extends Thread{
    private MyService2 myService2;

    public Thread2B(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        for (int i=0;i<50000;i++){
            myService2.map.put("线程B"+(i+1),"线程B"+i+1);
            System.out.println("线程B"+(i+1));
        }
    }
}
public class ConcurrentHashMap_Demo2 {

    public static void main(String[] args) {
        MyService2 myService2 = new MyService2();

        Thread2A thread2A = new Thread2A(myService2);
        Thread2B thread2B = new Thread2B(myService2);

        thread2A.start();
        thread2B.start();
    }
}
