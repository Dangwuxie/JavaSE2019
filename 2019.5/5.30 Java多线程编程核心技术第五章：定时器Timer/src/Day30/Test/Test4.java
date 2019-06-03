package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dangxuchao
 * @Title: Test4
 * @ProjectName 5.30 Java多线程编程核心技术第五章：定时器Timer
 * @Description: TimerTask类的cancel()方法：将自身从任务队列中清除
 * @date 2019/6/4 0:26
 */
public class Test4 {
    private static Timer timer4 = new Timer();
    static public class MyTask4A extends TimerTask{
        @Override
        public void run() {
            System.out.println("A运行了！时间为："+new Date());
            this.cancel();
            //timer4.cancel();
        }
    }
    static public class MyTask4B extends TimerTask{
        @Override
        public void run() {
            System.out.println("B运行了！时间为："+new Date());
        }
    }
    public static void main(String[] args) {
        try{
            MyTask4A task4A = new MyTask4A();
            MyTask4B task4B = new MyTask4B();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString4 = "2019-6-4 00:39:50";

            Date dateRef4 = sdf.parse(dateString4);
            System.out.println("字符串时间："+ dateRef4.toLocaleString()
                    +"当前时间："+ new Date().toLocaleString());
            timer4.schedule(task4A,dateRef4,2000);
            timer4.schedule(task4B,dateRef4,2000);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
/*
运行结果：

    字符串时间：2019-6-4 0:39:50当前时间：2019-6-4 0:39:54
    A运行了！时间为：Tue Jun 04 00:39:54 CST 2019
    B运行了！时间为：Tue Jun 04 00:39:54 CST 2019
    B运行了！时间为：Tue Jun 04 00:39:56 CST 2019
    B运行了！时间为：Tue Jun 04 00:39:58 CST 2019
    B运行了！时间为：Tue Jun 04 00:40:00 CST 2019
    B运行了！时间为：Tue Jun 04 00:40:02 CST 2019
    B运行了！时间为：Tue Jun 04 00:40:04 CST 2019
    B运行了！时间为：Tue Jun 04 00:40:06 CST 2019
    B运行了！时间为：Tue Jun 04 00:40:08 CST 2019
 */