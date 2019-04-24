package Day21.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //
        Collections.addAll(list,"C","B","A","d");
        //将集合转为线程安全集合
        List<String> listSafe = Collections.synchronizedList(list);
        System.out.println(list);
        //集合排序
        Collections.sort(list);
        System.out.println(list);
        //集合反转
        Collections.reverse(list);
        System.out.println(list);
    }
}
