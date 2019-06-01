import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 请编写程序统计每种不同的个位数字出现的次数。
 * 例如：给定N = 100311，则有2个0，3个1，和1个3。
 * 输入
 * 100311
 * 输出
 * 0:2
 * 1:3
 * 3:1
 */

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] ch = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            list.add(0);
        }

        for (int i = 0;i < ch.length;i++){
            list.set(ch[i]-'0',list.get(ch[i]-'0')+1);
        }
        for (int i = 0;i < list.size();i++){
            System.out.println(i+":"+list.get(i));
        }

    }
}

/*
运行结果实例：
    11100333355888999999
    0:2
    1:3
    2:0
    3:4
    4:0
    5:2
    6:0
    7:0
    8:3
    9:6
 */