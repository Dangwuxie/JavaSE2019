package dxc.多线程.Java并发编程核心方法与框架.ExecutorAndThreadPoolExecutor;

/**
 * @author 灵魂编程者
 * @Title: MyRunnable
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/28 20:48
 */
public class MyRunnable implements Runnable {
    private String username;

    public MyRunnable(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()
                    +" username="+username+" begin "+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()
                    +" username="+username+" end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
