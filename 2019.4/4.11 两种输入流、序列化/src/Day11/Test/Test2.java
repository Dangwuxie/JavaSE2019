package Day11.Test;
//Java.util.Scanner类

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据：");
        if (scanner.hasNext()){
            System.out.println("输入内容为："+scanner.next());
        }
    }
}
