package Day05.Test;
//观察设置优先级时出现的异常

public class Test11 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.setPriority(11);
    }
}
