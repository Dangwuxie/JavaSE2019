








public class Test3{
    public static void main(String[] args){
        String str1 = new String("hello");
        String str2 = new String("hello");
        String str3 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str1);
    }
}