package Day19.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");
        //输出Map集合
        //Map ->Set
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        //取得Set接口迭代器
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        //3、迭代输出
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry =
                    iterator.next();
            System.out.println(entry.getKey()+
            " = "+entry.getValue());
        }

    }
}
