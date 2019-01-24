package Day20.Test;

public class Test3 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            private String name;
            public void Runnable(String name){
                this.name = name;
            }
            @Override
            public void run() {
                for (int i = 0;i < 3;i++){
                    System.out.println(this.name+"、"+i);
                }
            }
        }).start();
    }
}
