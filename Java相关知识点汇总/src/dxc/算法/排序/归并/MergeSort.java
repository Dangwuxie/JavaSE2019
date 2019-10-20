package dxc.算法.排序.归并;

/**
 * @author 灵魂编程者
 * @Title: MergeSort
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/20 15:32
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr,0,arr.length-1);
    }

    public static void sortProcess(int[] arr,int l,int r){
        if (l == r){
            return;
        }
        int mid = l + ((r - l)>>1);
        sortProcess(arr,l,mid);
        sortProcess(arr,mid+1,r);

        merge(arr,l,mid,r);
    }

    public static void merge(int[] arr,int l,int mid,int r){

        int[] help = new int[r-l+1];
        int i = 0;
        int a = l;
        int b = mid+1;

        while (a<=mid && b<=r){
            help[i++] = arr[a]<=arr[b] ? arr[a++]:arr[b++];
        }

        while (a <= mid){
            help[i++] = arr[a++];
        }

        while (b <= r){
            help[i++] = arr[b++];
        }

        for (int j=0;j<help.length;j++){
            arr[l+j] = help[j];
        }

    }
}
