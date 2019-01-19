public class Test9 {
    public static void main(String[] args) {
        System.out.println(getTotal(100));
    }
    public static int getTotal(int x){
        if (x == 1){
            return 1;
        }else {
            return x + getTotal(--x);
        }
    }
}
