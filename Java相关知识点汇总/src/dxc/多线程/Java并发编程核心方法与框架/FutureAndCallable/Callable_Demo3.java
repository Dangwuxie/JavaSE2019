package dxc.多线程.Java并发编程核心方法与框架.FutureAndCallable;

import java.util.concurrent.*;

/**
 * @author 灵魂编程者
 * @Title: Callable_Demo3
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 18:47
 */

/*
* 使用ExecutorService的方法submit(Runnable,T result)
* */
class Userinfo{
    private String username;
    private String password;

    public Userinfo() {
        super();
    }

    public Userinfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
class MyRunnable implements Runnable{
    private Userinfo userinfo;
    private Userinfo userinfo2;
    public MyRunnable(Userinfo userinfo,Userinfo userinfo2) {
        super();
        this.userinfo = userinfo;
        this.userinfo2 = userinfo;
    }

    @Override
    public void run() {
        userinfo.setUsername("张三");
        userinfo.setPassword("666777");
        userinfo2.setUsername("李四");
        userinfo2.setPassword("777888");
    }
}


public class Callable_Demo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Userinfo userinfo = new Userinfo();
        Userinfo userinfo2 = new Userinfo();
        MyRunnable runnable = new MyRunnable(userinfo,userinfo2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,3,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        Future<Userinfo> future = executor.submit(runnable,userinfo);
        System.out.println("开始时间："+System.currentTimeMillis());
        userinfo = future.get();
        System.out.println("获取值："+userinfo.getUsername()
                +" "+userinfo.getPassword());
        System.out.println("结束时间："+System.currentTimeMillis());

    }
}
/*
    开始时间：1573470866546
    获取值：李四 777888
    结束时间：1573470866548
* */