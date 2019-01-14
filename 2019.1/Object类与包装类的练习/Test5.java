public class Test5{
    public static void main(String[] args){
        StringBuilder words = new StringBuilder("helloworld");
        System.out.println(words.delete(0,5).insert(0,123));

    }
}