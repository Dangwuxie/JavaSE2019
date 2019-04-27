package Day21.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//收集器；将数据过滤后的到具体数据；
public class Test11 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C","D","A","A");
        Stream<String> stream = list.stream();
        System.out.println(stream.filter(
                e -> e.contains("A")).collect(Collectors.toList()));
        //收集完的数据依然属于List集合，可以直接用List进行接收；
        /*List<String> resultList = stream.filter(
                e -> e.contains("A")).collect(Collectors.toList());
        System.out.println(resultList);*/
    }
}
