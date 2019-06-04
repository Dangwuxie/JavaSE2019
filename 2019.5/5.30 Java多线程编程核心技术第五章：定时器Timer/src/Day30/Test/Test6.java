package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test6
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description:
 * 测试schedule方法不延时的情况
 * 还有跟延时时的情况
 * @date 2019/6/4 8:09
 */

public class Test6 {
    private static Timer timer = new Timer();
    private static int runCount = 0;

    static public class MyTask6 extends TimerTask{
        @Override
        public void run() {
            try {
                System.out.println("Task开始执行："+new Date());
                Thread.sleep(1000);
                System.out.println("Task结束执行："+new Date());
                runCount++;
                if (runCount == 5){
                    timer.cancel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        try {
            MyTask6 task6 = new MyTask6();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-6-4 8:24:00";
            Date dateRef6 = sdf.parse(dateString);
            System.out.println("字符串时间："+ dateRef6.toLocaleString()
                    +"当前时间："+ new Date().toLocaleString());
            timer.schedule(task6,dateRef6,2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
/*
运行结果：测试schedule方法不延时的情况

    字符串时间：2019-6-4 8:24:00当前时间：2019-6-4 8:23:30
    Task开始执行：Tue Jun 04 08:24:00 CST 2019
    Task结束执行：Tue Jun 04 08:24:01 CST 2019
    Task开始执行：Tue Jun 04 08:24:02 CST 2019
    Task结束执行：Tue Jun 04 08:24:03 CST 2019
    Task开始执行：Tue Jun 04 08:24:04 CST 2019
    Task结束执行：Tue Jun 04 08:24:05 CST 2019
    Task开始执行：Tue Jun 04 08:24:06 CST 2019
    Task结束执行：Tue Jun 04 08:24:07 CST 2019
    Task开始执行：Tue Jun 04 08:24:08 CST 2019
    Task结束执行：Tue Jun 04 08:24:09 CST 2019
 */
/*
延时时的schedule方法运行后的结果:
可以看出延时是的周期循环时间是以任务的执行时间为准的；
任务执行时间是2秒，而周期时间是1秒，那么每两个任务间隔就是两秒
    字符串时间：2019-6-4 8:24:00当前时间：2019-6-4 8:44:13
    Task开始执行：Tue Jun 04 08:44:13 CST 2019
    Task结束执行：Tue Jun 04 08:44:15 CST 2019
    Task开始执行：Tue Jun 04 08:44:15 CST 2019
    Task结束执行：Tue Jun 04 08:44:17 CST 2019
    Task开始执行：Tue Jun 04 08:44:17 CST 2019
    Task结束执行：Tue Jun 04 08:44:19 CST 2019
    Task开始执行：Tue Jun 04 08:44:19 CST 2019
    Task结束执行：Tue Jun 04 08:44:21 CST 2019
    Task开始执行：Tue Jun 04 08:44:21 CST 2019
    Task结束执行：Tue Jun 04 08:44:23 CST 2019

 */