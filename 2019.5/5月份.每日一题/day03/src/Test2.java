import java.util.Scanner;

/**
 * 在输入的一串字符里输出最长的一串数字
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            int count = 0;
            int max = 0;
            int end = 0;
            for (int i = 0;i < str.length();i++){
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    count++;
                    if (max < count){
                        max = count;
                        end = i;
                    }
                }else {
                    count = 0;
                }
            }
            //此处end+1原因是该substring方法是左闭右开区间；
            System.out.println(str.substring(end-max+1,end+1));

        }


    }
}
/*
    运行结果：
    123qq
    123
    eq123da12345sda
    12345
 */