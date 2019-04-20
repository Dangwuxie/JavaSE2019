package Day17.Test;

import java.util.LinkedList;
import java.util.List;
//LinkedList的练习，使用效果上没有任何区别；

public class Test7 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Java");
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        list.remove("Hello");
        System.out.println(list);
    }
}
