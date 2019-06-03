package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test3
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description: schedule(TimerTask task, Date firstTime, long period) ：
 * 作用：在指定的日期之后，按指定的间隔周期性的无限循环地执行某一任务；
 * 1、
 * 在未来执行的效果：从运行结果来看，
 * 每隔几秒执行一次TimerTask任务，并且是无限期地重复执行；
 * @date 2019/6/3 23:42
 */
public class Test3 {
    private static Timer timer = new Timer();
    static public class MyTask3 extends TimerTask{
        @Override
        public void run() {
            try {
                Thread.sleep(4000);
                System.out.println("运行了，时间为："+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try{
            MyTask3 myTask3 = new MyTask3();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-6-3 23:56:00";
            Date dateRef3 = sdf.parse(dateString);
            System.out.println("字符串时间："+ dateRef3.toLocaleString()
                    +"当前时间："+ new Date().toLocaleString());
            timer.schedule(myTask3,dateRef3,2000);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
/*
运行时间：

    字符串时间：2019-6-3 23:51:00当前时间：2019-6-3 23:50:27
    运行了，时间为：Mon Jun 03 23:51:00 CST 2019
    运行了，时间为：Mon Jun 03 23:51:02 CST 2019
    运行了，时间为：Mon Jun 03 23:51:04 CST 2019
    运行了，时间为：Mon Jun 03 23:51:06 CST 2019
    运行了，时间为：Mon Jun 03 23:51:08 CST 2019
    运行了，时间为：Mon Jun 03 23:51:10 CST 2019
    运行了，时间为：Mon Jun 03 23:51:12 CST 2019
    运行了，时间为：Mon Jun 03 23:51:14 CST 2019
    运行了，时间为：Mon Jun 03 23:51:16 CST 2019
    运行了，时间为：Mon Jun 03 23:51:18 CST 2019
    运行了，时间为：Mon Jun 03 23:51:20 CST 2019
 */