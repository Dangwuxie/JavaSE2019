package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test7
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description: scheduleAtFixedRate(TimerTask task, Date firstTime,long period)
 * 延时与不延时的区别：
 * @date 2019/6/4 8:52
 */
public class Test7 {
    private static Timer timer = new Timer();
    private static int runCount = 0;
    static public class MyTask7 extends TimerTask{
        @Override
        public void run() {

            try {
                System.out.println("开始运行了："+new Date());
                Thread.sleep(3000);
                System.out.println("结束运行了："+new Date());
                runCount++;
                if (runCount == 4){
                    timer.cancel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {

        try {
            MyTask7 myTask7 = new MyTask7();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-6-4 8:58:00";
            Date dateRef = sdf.parse(dateString);
            System.out.println("字符串时间："+dateRef.toLocaleString()
                    +"当前时间："+new Date());
            timer.scheduleAtFixedRate(myTask7,dateRef,1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


/*
    延时后的运行结果：，跟schedule的结果一样：

    字符串时间：2019-6-4 8:58:00当前时间：Tue Jun 04 09:01:26 CST 2019
    开始运行了：Tue Jun 04 09:01:26 CST 2019
    结束运行了：Tue Jun 04 09:01:29 CST 2019
    开始运行了：Tue Jun 04 09:01:29 CST 2019
    结束运行了：Tue Jun 04 09:01:32 CST 2019
    开始运行了：Tue Jun 04 09:01:32 CST 2019
    结束运行了：Tue Jun 04 09:01:35 CST 2019
    开始运行了：Tue Jun 04 09:01:35 CST 2019
    结束运行了：Tue Jun 04 09:01:38 CST 2019
 */
/*
不延时的结果：不会被参数中的周期时间period而限制，
本次任务执行完就接着下次的任务执行；
    字符串时间：2019-6-4 8:58:00当前时间：Tue Jun 04 09:02:57 CST 2019
    开始运行了：Tue Jun 04 09:02:57 CST 2019
    结束运行了：Tue Jun 04 09:02:58 CST 2019
    开始运行了：Tue Jun 04 09:02:58 CST 2019
    结束运行了：Tue Jun 04 09:02:59 CST 2019
    开始运行了：Tue Jun 04 09:02:59 CST 2019
    结束运行了：Tue Jun 04 09:03:00 CST 2019
    开始运行了：Tue Jun 04 09:03:00 CST 2019
    结束运行了：Tue Jun 04 09:03:01 CST 2019

 */