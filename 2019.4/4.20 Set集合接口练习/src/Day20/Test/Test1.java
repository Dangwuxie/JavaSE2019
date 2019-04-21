package Day20.Test;

import java.util.HashSet;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("AAAA");
        set.add("Hello");
        set.add("BBBB");
        set.add("World");
        //重复元素
        set.add("Hello");
        set.add("Java");
        System.out.println(set);
    }
}
