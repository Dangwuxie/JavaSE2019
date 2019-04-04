package Day03.Test;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄");
        scanner.useDelimiter("\n");
        if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println("年龄为"+scanner.next());
        }
    }
}
