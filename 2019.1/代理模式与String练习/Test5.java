
public class Test5{
    public static void main(String[] args){
        char[] array = new char[]{'h','e','l','l','o'};
        String str = new String(array);
        String str2 = new String(array,2,2);
        System.out.println(str);
        System.out.println(str2);
    }
}