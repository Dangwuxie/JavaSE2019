package Jan.Day16;

public class Test3 {
    public static void main(String[] args){
        System.out.println("1.数学计算开始前");
        try {
            System.out.println("2.数学计算开始"+(10/2));
        } finally {
            System.out.println("4.finally代码块");
        }
        System.out.println("3.数学计算结束");
    }
}
