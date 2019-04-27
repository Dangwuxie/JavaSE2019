package Day21.Test;
//Map/reduce模型


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Test10 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C","D","F");
        //实例化Stream对象;
        Stream<String> stream = list.stream();
        System.out.println(stream.count());
    }
}
