package dxc.算法.排序.冒泡;

/**
 * @author 灵魂编程者
 * @Title: BubbleSort
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/17 22:51
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i=arr.length;i>0;i--){
            for (int j=0;j<i-1;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int j,int k){
        arr[j] = arr[j] ^ arr[k];
        arr[k] = arr[j] ^ arr[k];
        arr[j] = arr[j] ^ arr[k];
    }


}
