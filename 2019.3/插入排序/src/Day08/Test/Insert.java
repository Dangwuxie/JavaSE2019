package Day08.Test;

import java.util.Random;

public class Insert {
    /**
     * 冒泡排序；
     * @param data
     */
    public static void bubbleSort(int[] data){
        long start = System.currentTimeMillis();
        int n = data.length;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n-i-1;j++ ){
                boolean flag = false;
                if (data[j] > data[j+1]){
                    flag = true;
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
                if (!flag){
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序耗时"+(end-start)+"毫秒");
    }
    /**
     * 直接插入排序；
     * @param data
     */
    public static void insertSort(int[] data){
        long start = System.currentTimeMillis();
        int[] dabs = data;
        int n = dabs.length;
        if (n <= 1){
            return;
        }else{
            for (int i = 1;i < dabs.length;i++){
                int value = dabs[i];
                for (int j = i-1;j >= 0;j--){
                    if (dabs[j] < value){
                        dabs[j+1] = value;
                    }else{
                        dabs[j+1] = dabs[j];
                        if (j == 0){
                            dabs[j] = value;
                        }
                    }

                }

            }
        }
        long end = System.currentTimeMillis();
        System.out.println("直接插入排序耗时"+(end-start)+"毫秒");
    }

    /**
     * 折半插入排序；
     * 这种二分插入的方法，就是二分查找跟直接插入的结合
     * 相比以前的直接插入方式，二分法明显节省了一半时间；
     * 直接查找到要插入的位置，然后直接插入；
     * @param data
     */
    public static void binaryInsertSort(int[] data){
        long start = System.currentTimeMillis();
        int[] dabs = data;
        int n = dabs.length;
        if (n <= 1){
            return;
        }else{
            for (int i = 1;i < n;i++){
                int left = 0;
                int high = i-1;
                int value = dabs[i];

                while(left <= high){
                    int mid = (left+high)/2;
                    if (dabs[mid] < value){
                        left = mid+1;
                    }else{
                        high = mid-1;
                    }
                }
                //循环结束后mid=left=high;
                //下面就要给mid的位置插入value;
                int j ;
                for ( j = i-1; j > high;j--){
                    dabs[j+1] = dabs[j];
                }
                dabs[j+1] = value;
               // }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("折半插入排序耗时"+(end-start)+"毫秒");
    }

    /**
     * 希尔排序，就是把一串数据依次分成从大到小的模块
     * 每次采用插入排序法排完区块里的数据后再逐渐减少模块的大小
     * 知道模块为单个元素截至；
     * @param data
     */
    public static void shellSort(int[] data){
        long start = System.currentTimeMillis();
        int step = data.length/2;
        while (step != 0){
            int n = data.length;

            for (int i = step;i < n;i++){
                int tmp = data[i];
                int j = i - step;
                /*while(j >= 0 && data[j] > tmp){
                    data[j+step] = data[j];
                    j = j -step;
                }*/
                for (;j >= 0;j -= step){
                    if (data[j] > tmp){
                        data[j+step] = data[j];
                    }else{
                        break;
                    }
                }
                data[j+step] = tmp;
            }
            step = step/2;
        }
        long end = System.currentTimeMillis();
        System.out.println("希尔排序耗时为"+(end-start)+"毫秒");
    }

    /**
     * 输出排序后的数组；
     * @param data
     */
    public static void print(int[] data){
        for (int o : data){
            System.out.print(o+"  ");
        }
    }

    /**
     * 选择排序；
     * 无序的一组数，每次从无序的数集中选择最小的一个数字，
     * 添加到有序数组的最后一位；直到无序数组为空
     * @param data
     */
    public static void selectionSort(int[] data){

        int n = data.length;
        for (int i = 0;i < n-1;i++){
            int minIndex = i;
            for (int j = i+1;j < n;j++){
                if (data[minIndex] > data[j]){
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        System.out.println("选择排序的耗时为"+(end - start)+"毫秒");
    }

    /**
     * @param n 要生成的数组长度
     * @param L 数组左边界
     * @param R 数组右边界
     * @return
     */
    public static int[] generateArray(int n,int L,int R){
        int array[] = new int[n];
        if (L > R){
            throw new IllegalArgumentException("范围非法");
        }else{
            for (int i = 0;i < n;i++){
                array[i] = new Random().nextInt((R - L+1)+ L);
            }
            return array;
        }
    }

    /**
     * 生成一个近乎有序的数组
     * @param n 要生成的数据大小
     * @param switchTimes 要交换的次数
     * @param range 随机生成范围
     * @return
     */
    public static int[] generateNearlySortArray(int n,int switchTimes,int range){
        int data[] = new int[n];
        for (int i = 0;i < n;i++){
            data[i] = i;
        }
        //然后就要交换元素
        for (int i = 0;i < switchTimes;i++){
            Random random = new Random();
            int a = random.nextInt(range);
            int b = random.nextInt(range);
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
        return data;
    }

    public static void quickSort(int[] array){
        int n = array.length;
        if (n <= 1){
            return;
        }
        quickSortInternal(array,0,n-1);
    }
    private static void quickSortInternal(int[] array,int l,int r){
        if (l >= r){
            return;
        }
        int q = partition(array,l,r);
        quickSortInternal(array,l,q-1);
        quickSortInternal(array,q+1,r);

    }
    /**
     *  分区点
     * @param array
     * @param l
     * @param y
     */
    private static int partition(int[] array,int l,int r){
        int v = array[l];
        int j = l;
        int i = l + 1 ;
        for (;i <= r;i++){
            if (array[i] < v){
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }
    private static void swap(int[] array,int l,int r){
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
    /*public static void mergeSort(int[] array){
        int n = array.length;
        if (n <= 0){
            return;;
        }
        int mid = n / 2;
        mergeInternal(array,0,n-1);
    }
    /*private static void mergeInternal(int[] array;int low,int high){
        int mid = (low+(high-low)) / 2;
        //左边小数组
        mergeInternal(array,low,mid-1);
        //右边小数组
        mergeInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }
    /*private static void merge(int[] array,int p,int q,int r){

    }*/

}

