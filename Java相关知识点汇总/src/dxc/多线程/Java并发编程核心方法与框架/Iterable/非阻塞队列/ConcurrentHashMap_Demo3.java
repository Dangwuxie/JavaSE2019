package dxc.多线程.Java并发编程核心方法与框架.Iterable.非阻塞队列;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 灵魂编程者
 * @Title: ConcurrentHashMap_Demo3
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 14:32
 */

class MyService3{
    public ConcurrentHashMap map = new ConcurrentHashMap();
}

class Thread3A extends Thread{
    private MyService3 myService3;

    public Thread3A(MyService3 myService3) {
        this.myService3 = myService3;
    }

    @Override
    public void run() {
        for (int i=0;i<50000;i++){
            myService3.map.put("线程A"+(i+1),"线程A"+i+1);
            System.out.println("线程A"+(i+1));
        }
    }
}

class Thread3B extends Thread{
    private MyService3 myService3;

    public Thread3B(MyService3 myService3) {
        this.myService3 = myService3;
    }

    @Override
    public void run() {
        for (int i=0;i<50000;i++){
            myService3.map.keySet().iterator();
            myService3.map.put("线程B"+(i+1),"线程B"+i+1);
            System.out.println("线程B"+(i+1));
        }
    }
}
public class ConcurrentHashMap_Demo3 {

    public static void main(String[] args) {
        MyService3 myService3 = new MyService3();
        Thread3A thread3A = new Thread3A(myService3);
        Thread3B thread3B = new Thread3B(myService3);

        thread3A.start();
        thread3B.start();

    }
}
