package Jan.Day16;
public class Test2 {
        public static void main(String[] args){
            System.out.println("1.数学计算开始前");
            try {
                System.out.println("2.数学计算开始"+(10/0));
            } catch (ArithmeticException e) {
                //System.out.println("程序出错");
                //输出错误堆栈信息
                e.printStackTrace();
            }
            System.out.println("3.数学计算结束");
        }
}
