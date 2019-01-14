//判断字符串是否为空
public class Test2{
    public static void main(String[] args){
        String words = null;
        //判断字符串是否为空
        //以后在判断字符串是否为空的时候
        //先判断是否为空引用
        if(words == null || words.isEmpty()){
            System.out.println("空字符串")；
        }
    }
}