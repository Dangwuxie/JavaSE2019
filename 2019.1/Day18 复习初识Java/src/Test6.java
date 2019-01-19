public class Test6 {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入字符：");
        char ch = (char) System.in.read();
        switch(ch){
            case 'a':
                System.out.println("1 2 3");
                break;
            case 'b':
                System.out.println("4 5 6");
                break;
            case 'c':
                System.out.println("7 8 9");
                break;
            default:
                System.out.println("AAAAA");
        }
    }
}
