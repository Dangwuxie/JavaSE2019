package Day17.Test;

import java.util.ArrayList;
import java.util.List;

//ArrayList子类练习
public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Today");
        list.add("420");
        //重复数据
        list.add("Today");
        System.out.println(list);

    }
}
