package Day15.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test7 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        //当key值重复，再次put变为相应value的更新操作；
        map.put(1,"HELLO");
        map.put(3,"Java");
        map.put(2,"bet");
        System.out.println(map.get(1));
        System.out.println(map.get(99));
        //取得当前Map中的所有key值
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" 、");
        }
    }
}
