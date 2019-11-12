package dxc.多线程.Java并发编程核心方法与框架.Iterable.非阻塞队列;

import java.util.HashMap;

/**
 * @author 灵魂编程者
 * @Title: ConcurrentHashMap_Demo1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/12 13:47
 */

/*
* 验证HashMap为非线程安全
* 单线程操作是安全的，多线程操作时出现假死，
* 说明HashMap不能被多个线程所操作，也就是线程不安全；
* */
class MyService1{
    public HashMap map = new HashMap();
}

class Thread1A extends Thread{
    private MyService1 myService1;

    public Thread1A(MyService1 myService1) {
        this.myService1 = myService1;
    }

    @Override
    public void run() {
        for (int i=0;i<50000;i++){
            myService1.map.put("线程A"+(i+1),"线程A"+i+1);
            System.out.println("线程A"+(i+1));
        }
    }
}

class Thread1B extends Thread{
    private MyService1 myService1;

    public Thread1B(MyService1 myService1) {
        this.myService1 = myService1;
    }

    @Override
    public void run() {
        for (int i=0;i<50000;i++){
            myService1.map.put("线程B"+(i+1),"线程B"+i+1);
            System.out.println("线程B"+(i+1));
        }
    }
}

public class ConcurrentHashMap_Demo1 {

    public static void main(String[] args) {
        MyService1 myService1 = new MyService1();

        Thread1A thread1A = new Thread1A(myService1);
        Thread1B thread1B = new Thread1B(myService1);

        thread1A.start();
        thread1B.start();
    }
}
