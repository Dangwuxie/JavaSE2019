package Day20.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test9 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        list.add("D");
        //取得iterator对象
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("B")){
                iterator.remove();
                //注意：此处若是使用集合提供的remove方法，就会产生
                //ConcurrentModificationException；线程修改异常
                //list.remove("B");
                continue;
            }
            System.out.println(str);
        }
    }
}
