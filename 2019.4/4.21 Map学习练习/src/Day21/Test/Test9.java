package Day21.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//forEach集合输出；
public class Test9 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,4,3,2,1,5,6,7);
        list.forEach(System.out::print);
        System.out.println();
        //取得Stream对象；
        Stream<Integer> stream = list.stream();
        //统计出集合中所有偶数的个数
        System.out.println(stream.filter(e -> e%2 == 0).count());
        //取得最大值
        System.out.println(stream.max(Integer::compareTo).get());
    }
}
