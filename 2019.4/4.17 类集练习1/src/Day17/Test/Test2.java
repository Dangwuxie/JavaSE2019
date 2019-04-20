package Day17.Test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //集合里面只保存String类型
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        //重复数据
        list.add("Hello");
        //通过下标索引来获取对象信息
        System.out.println(list.get(2));

        //输出长度以及判断是否为空
        System.out.println(list.size()+"  "+list.isEmpty());
        //移除“Hello”的元素
        System.out.println(list.remove("Hello"));
        //判断是否包含“World”元素
        System.out.println(list.contains("World"));
        System.out.println(list.contains("Hello"));
        System.out.println(list);
    }
}
