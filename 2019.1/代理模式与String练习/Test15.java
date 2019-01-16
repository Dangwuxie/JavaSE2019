








//字符串首字母大写
public class Test15{
    public static void main(String[] args){
        String words = "hello World";
        System.out.println(upperCaseFirstChar(words));
    }
    public static String upperCaseFirstChar(String word){
        return word.substring(0,1).toUpperCase()+word.substring(1);
    }
}