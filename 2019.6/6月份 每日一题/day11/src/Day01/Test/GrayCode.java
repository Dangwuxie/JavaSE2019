package Day01.Test;

/**
 * @author Dangxuchao
 * @Title: GrayCode
 * @ProjectName 6月份 每日一题
 * @Description: Gray Code是一个数列集合，每个数使用二进位来表示，
 * 假设使用n位元来表示每个数好了，任 两个数之间只有一个位元值不同，例如以下为3位元的Gray Code：
 * 000 001 011 010 110 111 101 100由定义可以知道，
 * Gray Code的顺序并不是唯一的，例如将上面的数列反过来写，也是一组GrayCode：
 * 100 101 111 110 010 011 001 000
 * Gray Code是由贝尔实验室的Frank Gray在1940年代提出的，
 * 用来在使用PCM（Pusle CodeModulation）方法传送讯号时避免出错，并于1953年三月十七日取得美国专利。
 * @date 2019/6/2 20:29
 */

/**
 * 举个例子：
 * n=1时返回：['0','1']
 * n=2时返回['00' '01' '10' '11']
 * n=3时返回['000' '001' '010' '011' '100' '101' '110' '111'];
 * 可以看出每次n增加一次，每个格雷码相对于上一次增加一个0或者1，
 * 并且每次增加的格雷码是n-1时的两倍；
 */
public class GrayCode {
    public static void main(String[] args) {
        String[] str11 = getGray(4);
        for (String o : str11){
            System.out.print(o+" ");
        }
    }
    public static String[] getGray(int n) {
        String[] str ;
        if (n == 1){
            str = new String[]{"0","1"};
        }else{
            str = getGray(n-1);
            String[] resStr = new String[str.length*2];
            for (int i = 0;i < str.length;i++){
                resStr[i] = "0"+str[i];
                resStr[str.length*2-1-i] = "1"+str[i];
            }
            return resStr;
        }
        return str;

    }
}
