package dxc.多线程.Java并发编程核心方法与框架.FutureAndCallable;

import java.util.concurrent.Callable;

/**
 * @author 灵魂编程者
 * @Title: MyCallable
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/11 17:27
 */
public class MyCallable implements Callable {
    private int age;

    public MyCallable(int age) {
        super();
        this.age = age;
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return "返回值年龄是："+age;
    }
}
