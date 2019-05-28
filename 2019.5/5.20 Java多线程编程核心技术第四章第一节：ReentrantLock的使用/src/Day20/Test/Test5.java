package Day20.Test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int[] data = new int[N];

            //for循环赋值
            for (int i = 0;i < N;i++){
                data[i] = i;
            }
            System.out.println(lastNumber(data));
        }
    }
    public static int lastNumber(int[] data){
        //count,就是说记录每次跳过不为-1的元素的个数；
        int count = 0;
        int N = data.length;
        //num记录剩下的要删除的元素的个数；
        int num = N;
        /**
         * 下面这个for循环就是删除元素的
         * 题目并没有说是必须删除元素，
         * 所以可以将要删除的元素变成一个不相干的值
         * 然后直到数组全部变成这个值后，
         * 输出最后变成-1的这个元素；
         */
        int temp = 0;
        for (int i = 0;i < N;i++){

            if (count == 2 && data[i] != -1){
                temp = data[i];//temp的史命就是保存最后删除的那个元素；
                data[i] = -1;//每次将要删除的元素变为-1；
                count = 0;
                num--;//每当有一个元素变为-1，元素个数减1
                System.out.println(i+" "+num);
            }
            if(data[i] != -1 && count < 2){
                count++;
            }
            //当下标遍历到N-1的时候需要从0重新开始遍历，所以i=-1；
            if (i == N-1){
                i = -1;
            }
            //每一次for循环进来，都要检查一次剩余要删除的元素个数是否为0
            //如果为0，直接输出上次删除元素时保存的临时值temp；
            if (num == 0){
                return temp;
            }
        }
        return temp;
    }
}
