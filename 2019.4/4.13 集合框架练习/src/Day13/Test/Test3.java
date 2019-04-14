package Day13.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add(null);
        set.add("Hello");
        set.add("World");
        //重复元素

        set.add("World");
        set.add("hello");
        System.out.println(set);
    }
}
