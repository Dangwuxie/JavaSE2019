
public class Test8{
    public static void main(String[] args) throws Exception{
        String words = "比特科技";
        byte[] array = words.getBytes("UTF-8");
        for(byte b : array){
            System.out.println(b);
        }
    }
}