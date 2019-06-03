package Day30.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器Timer的使用
 * schedule(TimeTask task,Date time)：
 * 在指定的日期执行一次某一任务；
 */

public class Test1 {
    private static Timer timer = new Timer();
    static public class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("运行了！时间为："+new Date());

        }

    }
    public static void main(String[] args) {

        try {
            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataString = "2019-06-03 22:41:20";
            Date dateRef = sdf.parse(dataString);
            System.out.println("字符串时间："+ dateRef.toLocaleString()
                    +"当前时间："+ new Date().toLocaleString());
            timer.schedule(task,dateRef);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
