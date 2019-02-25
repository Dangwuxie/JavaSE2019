package Day23.Test;

//普通代码块，定义在方法中的代码块；
public class Test1 {
    public static void main(String[] args) {
        {
            int data = 20;
            System.out.println(data);
        }
        int data = 30;
        System.out.println(data);
    }
}
