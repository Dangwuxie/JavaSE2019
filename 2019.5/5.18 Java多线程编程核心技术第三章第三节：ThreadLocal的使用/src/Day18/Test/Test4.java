package Day18.Test;

/**
 * 解决get()返回null的问题：
 *
 */
class ThreadLocalExt extends ThreadLocal{
    @Override
    protected Object initialValue() {
        return"我是默认值  第一次get不再是null";
    }
}
public class Test4 {
    public static ThreadLocalExt t4 = new ThreadLocalExt();
    public static void main(String[] args) {
        if (t4.get() == null){
            System.out.println("没有放过值---");
            t4.set("放一次值");
        }
        System.out.println(t4.get());
        System.out.println(t4.get());
    }
}

/*
    运行结果：

    我是默认值  第一次get不再是null
    我是默认值  第一次get不再是null

        可以看出第一次get不再是null了,已经初始化好了；
 */