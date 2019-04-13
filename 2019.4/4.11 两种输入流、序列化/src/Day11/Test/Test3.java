package Day11.Test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("输入内容：");

        do {
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()){
                System.out.println("输入不合法请重新输入！");

            } else{
                System.out.println("输入内容是："+scanner.next());

            }
        } while (true);

    }
}
