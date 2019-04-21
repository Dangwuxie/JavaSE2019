package Day20.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("AAAA");
        set.add("Hello");
        set.add("BBBB");
        set.add("World");
        //重复元素
        set.add("Hello");
        set.add("Java");
        System.out.println(set);
        //TreeSet是用升序完成排序的 ；
    }
}
