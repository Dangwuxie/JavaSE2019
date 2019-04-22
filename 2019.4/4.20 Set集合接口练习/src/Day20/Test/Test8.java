package Day20.Test;

import java.util.*;

//使用Iterator实例化对象进行迭代输出
public class Test8 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("Java");
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
