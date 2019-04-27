package Day14.Test;
//使用Lambda表达式;
public class Test5 {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            for (int i = 0;i < 10;i++){
                System.out.println( "线程1"+", i ="+ i);
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0;i < 10;i++){
                System.out.println( "线程2"+", i ="+ i);
            }
        };
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
