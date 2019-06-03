package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test2
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description:
 * 	* 多个TimerTask任务及延时时，TimerTask是以队列的方式一个一个被顺序执行的，
 * 	所以执行的时间有可能和预期的时间不一致，因为前面的任务有可能消耗的时间较长，
 * 	那么后面的任务运行的时间也会被延迟；
 * 实例：结果,注意时间;运行结果：可以看出task1执行任务是立即执行，
 * 因为它是早于当前时间执行
 * task2就是晚于当前时间执行，按时执行；
 * @date 2019/6/3 23:14
 */
public class Test2 {
    private static Timer timer = new Timer();
    static public class MyTask1 extends TimerTask{
        @Override
        public void run() {
            try {
                Thread.sleep(4000);
                System.out.println("Task1运行了！时间为:"+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static public class MyTask2 extends TimerTask{
        @Override
        public void run() {
            System.out.println("Task2运行了！时间为："+new Date());
        }
    }
    public static void main(String[] args) {

        try {
            MyTask1 myTask1 = new MyTask1();
            MyTask2 myTask2 = new MyTask2();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString1 = "2019-6-3 23:28:30";
            String dateString2 = "2019-6-3 23:28:32";
            Date dateRef1 = sdf1.parse(dateString1);
            Date dateRef2 = sdf2.parse(dateString2);
            System.out.println("字符串时间："+ dateRef1.toLocaleString()
                    +"当前时间："+ new Date().toLocaleString());
            System.out.println("字符串时间："+ dateRef2.toLocaleString()
                    +"当前时间："+ new Date().toLocaleString());
            timer.schedule(myTask1,dateRef1);
            timer.schedule(myTask2,dateRef2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
/*
运行结果：可以看出task1执行任务是立即执行，因为它是早于当前时间执行
task2就是晚于当前时间执行，按时执行；

    字符串时间：2019-6-3 23:22:50当前时间：2019-6-3 23:23:01
    字符串时间：2019-6-3 23:23:20当前时间：2019-6-3 23:23:01
    Task1运行了！时间为:Mon Jun 03 23:23:01 CST 2019
    Task2运行了！时间为：Mon Jun 03 23:23:20 CST 2019
 */