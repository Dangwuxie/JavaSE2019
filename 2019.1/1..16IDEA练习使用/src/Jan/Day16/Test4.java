package Jan.Day16;
public class Test4 {
    public static void main(String[] args){
        System.out.println(test());
    }
    public static int test(){
        try{
            System.out.println(10/2);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 2;
        }finally {
            return 3;
        }
    }
}
