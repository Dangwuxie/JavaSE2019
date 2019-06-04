package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test8
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description: 验证schedule方法不具有追赶执行性：
 * @date 2019/6/4 9:06
 */
public class Test8 {
    private static Timer timer8 = new Timer();
    static public class MyTask8 extends TimerTask{
        @Override
        public void run() {
            System.out.println("开始运行了："+new Date());
            System.out.println("结束运行了："+new Date());
        }
    }
    public static void main(String[] args) {

        try {
            MyTask8 task8 = new MyTask8();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-6-4 9:10:00";
            Date dateRef = sdf.parse(dateString);
            System.out.println("字符串时间："+dateRef.toLocaleString()
                    +"当前时间："+new Date());
            timer8.schedule(task8,dateRef,5000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
/*
运行结果：schedule无追赶执行性

    字符串时间：2019-6-4 9:10:00当前时间：Tue Jun 04 09:11:43 CST 2019
    开始运行了：Tue Jun 04 09:11:43 CST 2019
    结束运行了：Tue Jun 04 09:11:43 CST 2019
    开始运行了：Tue Jun 04 09:11:48 CST 2019
    结束运行了：Tue Jun 04 09:11:48 CST 2019
    开始运行了：Tue Jun 04 09:11:53 CST 2019
    结束运行了：Tue Jun 04 09:11:53 CST 2019
    开始运行了：Tue Jun 04 09:11:58 CST 2019
    结束运行了：Tue Jun 04 09:11:58 CST 2019
 */