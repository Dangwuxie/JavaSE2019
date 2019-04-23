package Day21.Test;

import java.util.Map;
import java.util.TreeMap;

public class Test5 {
    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<>();
        map.put(2,"2号");
        map.put(0,"0号");
        map.put(1,"1号");
        System.out.println(map);
    }
}
