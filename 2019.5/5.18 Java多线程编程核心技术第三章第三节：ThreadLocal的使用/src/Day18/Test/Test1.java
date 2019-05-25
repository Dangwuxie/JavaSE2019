package Day18.Test;

/**
 * 观察ThreadLocal类对象的默认值；
 */
public class Test1 {

    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal();
        System.out.println("第一次调用get方法："+threadLocal.get());

        threadLocal.set("弟弟");
        System.out.println("第二次调用get方法："+threadLocal.get());
    }
}
