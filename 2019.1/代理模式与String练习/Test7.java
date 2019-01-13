public class Test7{
    public static void main(String[] args){
        String str2 = "12e2";
        if(isAllNumber(str2)){
            System.out.println("全是数字");
        }else{
            System.out.println("不全是数字");
        }
    }
    public static boolean isAllNumber(String str){
        //先将字符串转为char[]
        char[] array = str.toCharArray();
        for(int i = 0;i < array.length;i++){
            char ch = array[i];
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}