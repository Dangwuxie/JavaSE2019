













public class Test13{
    public static void main(String[] args){
        String words = "168.192.0.0.1";
        String[] words2 = words.split("\\.",6);
        for(String words3 : words2){
            System.out.println(words3);
        }
    }
}