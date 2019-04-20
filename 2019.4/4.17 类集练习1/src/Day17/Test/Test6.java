package Day17.Test;
//使用Vector
//用法上跟ArrayList是没有任何区别的
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test6 {
    public static void main(String[] args) {
        List<String> list = new Vector<>();
        list.add("Java");
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        list.remove("Hello");
        System.out.println(list);
    }
}
