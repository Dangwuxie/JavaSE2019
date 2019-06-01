import java.util.Scanner;

/**
 * @author ${Dangxuchao}
 * @Title: Test2
 * @ProjectName 5月份.每日一题
 * @Description:
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * 举个例子：
 * A[5] = {1,2,3,4,5}
 * 那么
 * B[1] = A[0]*A[2]*A[3]*A[4];
 * 就是说除了跟B数组下标i相同的A数组的元素不参加乘法之外
 * 其余的全部相乘；
 * @date 2019/6/1 21:51
 */

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要存入数组几个数？");
        int N = scanner.nextInt();
        System.out.println("请输入具体数字，中间以空格隔开：");
        int[] A = new int[N];
        for (int i = 0;i < N;i++){
            A[i] = scanner.nextInt();
        }
        int[] B = multiply(A);
        for (int o : B){
            System.out.print(o+" ");
        }
    }
    public static int[] multiply(int[] A){
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for (int i = 1;i < length;i++){
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for (int j = length-2;j >= 0;j--){
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}
/*
    运行结果：

    请输入你要存入数组几个数？
    4
    请输入具体数字，中间以空格隔开：
    2 4 6 8
    192 96 64 48
 */