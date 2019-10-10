package dxc.算法.排序.希尔;

/**
 * @author 灵魂编程者
 * @Title: ShellSort
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/8 12:16
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {5,2,3,4,9,1,7,3,8,9,6};
        shellSort(arr);
        for (int o:arr){
            System.out.print(o+" ");
        }
    }

    public static void shellSort(int[] arr){
        int d = arr.length;

        while (d>1){
            d = d/2;
            for (int x=0;x<d;x++){

                for (int i=x+d;i<arr.length;i=i+d){

                    int temp = arr[i];
                    int j;
                    for (j=i-d;j>=0&&arr[j]>temp;j=j-d){
                        arr[j+d] = arr[j];
                    }
                    arr[j+d] = temp;
                }
            }

        }
    }
}
