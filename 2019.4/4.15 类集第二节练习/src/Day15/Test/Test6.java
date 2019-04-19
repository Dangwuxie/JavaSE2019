package Day15.Test;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C","D","A","B");
        //modeCount=6
        Iterator<String> iterator = list.iterator();
        //取得集合迭代器(取得当前集合副本)
        //expectedModeCount = 6;
        while(iterator.hasNext()){
            //调用checkForComodification检查副本中的expectedModeCount是否
            //等于集合的ModeCount
            String str = iterator.next();
            if (str.equals("B")){
                //集合提供的remove();
                //此时modeCount=7;
                list.remove("B");
                //iterator.remove();
                continue;
            }
            System.out.print(str+"、");
        }
    }
}
