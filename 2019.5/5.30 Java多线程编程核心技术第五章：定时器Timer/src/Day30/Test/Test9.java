package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test9
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description: 验证scheduleAtFixedRate方法具有追赶性：
 * @date 2019/6/4 9:15
 */
public class Test9 {
    private static Timer timer = new Timer();
    public static class MyTask9 extends TimerTask{
        @Override
        public void run() {
            System.out.println("开始执行了："+ new Date());
            System.out.println("结束执行："+ new Date());
        }
    }
    public static void main(String[] args) {

        try {
            MyTask9 task9 = new MyTask9();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2019-6-4 9:20:00";
            Date dateRef = sdf.parse(dateString);
            System.out.println("字符串时间："+ dateRef.toLocaleString()
                    +"当前时间："+ new Date().toLocaleString());
            timer.scheduleAtFixedRate(task9,dateRef,2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
/*
运行结果：前面时间所对应的任务被补齐了，这就是Task任务追赶执行的特性；
    开始执行了：Tue Jun 04 09:22:29 CST 2019
    结束执行：Tue Jun 04 09:22:29 CST 2019
    开始执行了：Tue Jun 04 09:22:29 CST 2019
    结束执行：Tue Jun 04 09:22:29 CST 2019
    开始执行了：Tue Jun 04 09:22:29 CST 2019
    结束执行：Tue Jun 04 09:22:29 CST 2019
    开始执行了：Tue Jun 04 09:22:29 CST 2019
    结束执行：Tue Jun 04 09:22:29 CST 2019
    开始执行了：Tue Jun 04 09:22:30 CST 2019
    结束执行：Tue Jun 04 09:22:30 CST 2019
    开始执行了：Tue Jun 04 09:22:32 CST 2019
    结束执行：Tue Jun 04 09:22:32 CST 2019
    开始执行了：Tue Jun 04 09:22:34 CST 2019
    结束执行：Tue Jun 04 09:22:34 CST 2019
    开始执行了：Tue Jun 04 09:22:36 CST 2019
    结束执行：Tue Jun 04 09:22:36 CST 2019
    开始执行了：Tue Jun 04 09:22:38 CST 2019
    结束执行：Tue Jun 04 09:22:38 CST 2019
 */