package Day14.Test;

/**
 * 异常观察：
 * 如果调用wait/notify方法时没有持有适当的锁，
 * 抛出异常IllegalMonitorStateException,
 */

public class Test1 {

    public static void main(String[] args) {
        String newString = new String();
        try {
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 * 执行结果：
 * Exception in thread "main" java.lang.IllegalMonitorStateException
 * 	at java.lang.Object.wait(Native Method)
 * 	at java.lang.Object.wait(Object.java:502)
 * 	at Day14.Test.Test1.main(Test1.java:14)
 */