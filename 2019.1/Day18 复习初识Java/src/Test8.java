public class Test8 {
    public static void main(String[] args) {
        //方法重载
        print(13);
        print('a');
        print(13,'a');
    }
    public static void print(int x){
        System.out.print(x+" ");
    }
    public static void print(char ch){
        System.out.print(ch+" ");
    }
    public static void print(int y,char j){
        System.out.print(y+" ");
        System.out.print(j+" ");
    }
}
