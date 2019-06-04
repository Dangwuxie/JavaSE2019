package Day30.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test5
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description: 方法schedule(TimerTask task,long delay)：
 * 以当前的时间作为参考时间，在此时间基础上延迟指定delay毫秒后执行一次TimerTask任务；
 * public void schedule(TimerTask task, long delay, long period) ：
 * long period:加上指定周期性的循环；
 * @date 2019/6/4 7:55
 */


public class Test5 {
    static public class MyTask5 extends TimerTask{
        @Override
        public void run() {
            System.out.println("运行，运行时间为："+new Date());
        }
    }
    public static void main(String[] args) {
        MyTask5 task5 = new MyTask5();
        Timer tiemr = new Timer();
        System.out.println("当前时间为："+new Date().toLocaleString());
        //tiemr.schedule(task5,2000);
        tiemr.schedule(task5,2000,2000);
    }
}
/*
运行结果：

    当前时间为：2019-6-4 8:02:33
    运行，运行时间为：Tue Jun 04 08:02:35 CST 2019

 */
/*
    加了重复执行后的运行结果：

    当前时间为：2019-6-4 8:07:26
    运行，运行时间为：Tue Jun 04 08:07:28 CST 2019
    运行，运行时间为：Tue Jun 04 08:07:30 CST 2019
    运行，运行时间为：Tue Jun 04 08:07:32 CST 2019
    运行，运行时间为：Tue Jun 04 08:07:34 CST 2019
 */