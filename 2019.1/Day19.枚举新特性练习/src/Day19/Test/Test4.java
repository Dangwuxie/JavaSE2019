package Day19.Test;
@FunctionalInterface
interface Fuchouzhe{
    int test(int x,int y);
}
public class Test4 {
    public static void main(String[] args) {
        Fuchouzhe fuchouzhe = (x,y) -> x+y;
        System.out.println(fuchouzhe.test(50,20));
    }
}
