package Day11.Test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        System.out.println("请输入生日信息：");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            String birthday = scanner.next();
            System.out.println("输入生日为："+birthday);
        }else{
            System.out.println("输入的格式非法，不是生日");
        }
        scanner.close();
    }
}
