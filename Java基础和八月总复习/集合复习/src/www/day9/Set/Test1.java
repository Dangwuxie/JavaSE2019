package www.day9.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Dangxuchao
 * @Title: Test1
 * @ProjectName Java基础和八月总复习
 * @Description: Set
 * @date 2019/8/10 20:06
 */
public class Test1 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("D");
        set.add("B");
        set.add("C");

        set.add("A");
        set.add("A");
        System.out.println(set);
    }
}
