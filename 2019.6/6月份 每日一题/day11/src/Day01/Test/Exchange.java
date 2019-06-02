package Day01.Test;

import java.util.Scanner;

/**
 * @author Dangxuchao
 * @Title: Exchange
 * @ProjectName 6月份 每日一题
 * @Description: 无缓存交换两个数字
 * @date 2019/6/2 19:56
 */


public class Exchange {
    public static void main(String[] args) {
        int[] AB = new int[2];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < AB.length){
            AB[i] = scanner.nextInt();
            i++;
        }
        int[] AC = exchangeAB(AB);
        System.out.println(AC[0]+" "+AC[1]);
    }
    public static int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        System.out.println(AB[0]+" "+AB[1]);
        return AB;
    }
}
