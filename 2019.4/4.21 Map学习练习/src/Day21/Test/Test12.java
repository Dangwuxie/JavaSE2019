package Day21.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test12 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C","D","A","A");
        Stream<String> stream = list.stream();
        List<String> reaultList = stream.skip(1).limit(4).map(
                a -> a.toLowerCase()).collect(Collectors.toList());
        System.out.println(reaultList);
    }
}
