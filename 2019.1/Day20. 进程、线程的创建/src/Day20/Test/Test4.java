package Day20.Test;

public class Test4 {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            for (int x = 0;x < 3;x++){
                System.out.println(x);
            }
        };
        new Thread(runnable).start();
    }
}
