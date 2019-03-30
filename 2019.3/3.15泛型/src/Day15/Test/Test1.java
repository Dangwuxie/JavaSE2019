package Day15.Test;
@FunctionalInterface
interface Iutil<P,R>{
    P print(R r);
}
interface Iutil2<P>{
    P switchPara();
}
public class Test1 {
    public static void main(String[] args) {
        //引用静态方法
        Iutil<String,Integer> iu = String :: valueOf;
        String str = iu.print(1000);
        System.out.println(str.length());
       // Iutil<String,Integer> iu = () -> System.out.println(str.length());
        System.out.println();
        System.out.println();

        //引用对象方法
        //Iutil2<String> str2 = "hello"::toUpperCase;
        //System.out.println(str2.switchPara());
    }
}
