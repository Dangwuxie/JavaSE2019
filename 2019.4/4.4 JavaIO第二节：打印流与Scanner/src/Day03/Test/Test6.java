package Day03.Test;


import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");
        scanner.useDelimiter("\n");
        if (scanner.hasNext()){
            System.out.println("输入内容为"+scanner.next());
        }
    }
}
