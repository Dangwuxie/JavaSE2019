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
                int j = i-1;
                for (;j >= 0;j--){
                    if (dabs[j] > value){
                        dabs[j+1] = dabs[j];
                    }else{
                        break;
                        /*dabs[j+1] = dabs[j];
                        if (j == 0){
                            dabs[j] = value;
                        }*/
                    }
                }
                dabs[j+1] = value;
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
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("折半插入排序耗时"+(end-start)+"毫秒");
    }
    /**
     * 希尔排序，就是把一串数据依次分成从大到小的模块
     * 每次采用插入排序法排完区块里的数据后再逐渐减少模块的大小
     * 知道模块为单个元素截止；
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
        long start = System.currentTimeMillis();
        int n = data.length;
        if (n <= 1){
            return;
        }else{
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
        }
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
     * @return
     */
    public static int[] generateNearlySortArray(int n,int switchTimes){
        int data[] = new int[n];
        for (int i = 0;i < n;i++){
            data[i] = i;
        }
        //然后就要交换元素
        for (int i = 0;i < switchTimes;i++){
            Random random = new Random();
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
        return data;
    }

    /**
     * 快速排序；
     * @param array
     */
    public static void quickSort(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1){
            return;
        }
        quickSortInternal(array,0,n-1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序总耗时"+(end-start)+"毫秒");
    }
    public static void quickSort2(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        }
        quickSortInternal2(array, 0, n - 1);
        long end = System.currentTimeMillis();
        System.out.println("二路快速排序总耗时" + (end - start) + "毫秒");
    }
    public static void quickSort3(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        }
        quickSortInternal3(array, 0, n - 1);
        long end = System.currentTimeMillis();
        System.out.println("三路快速排序总耗时" + (end - start) + "毫秒");
    }
    private static void quickSortInternal(int[] array,int l,int r){
        if (l >= r){
            return;
        }
        int q = partition(array,l,r);
        quickSortInternal(array,l,q-1);
        quickSortInternal(array,q+1,r);

    }
    private static void quickSortInternal2(int[] array,int l,int r){
        if (l >= r){
            return;
        }
        int pivot = partition2(array,l,r);
        quickSortInternal2(array,l,pivot-1);
        quickSortInternal2(array,pivot+1,r);
    }
    private static void quickSortInternal3(int[] array,int l,int r){
        if (l >= r){
            return;
        }
        int pivot = partition3(array,l,r);
        quickSortInternal3(array,l,pivot-1);
        quickSortInternal3(array,pivot+1,r);
    }
    /**
     *  分区点
     * @param array 传入的数组
     * @param l  左边界
     * @param y  右边界
     */
    private static int partition3(int[] array,int l,int r){
        //三个指针，lt永远指向小于pivot区域的最后个元素
        //gt永远指向大于pivot区域的的第一个元素
        //i一直向后遍历元素；跟双路快排优点差别，双路快排是两个指针同时
        //分别从前向后、从后向前遍历；三路快排是三个指针，两个固定指向，一个从前向后遍历；
        int value = array[l];
        int lt = l;//刚开始lt指向小于v区域的前一个位置；即初始位置；
        int i = l+1;
        int gt = r+1;//同样gt后向前遍历，初始指向大于v区域的前一个位置；
        //下面开始遍历,从l+1处开始遍历
        while (i < gt){
            if (array[i] < value){
                swap(array,i,lt+1);
                lt++;
                i++;
            }else if(array[i] > value){
                swap(array,i,gt-1);
                gt--;
                //此处不能i++；因为当前i的元素是换回来的gt-1位置的元素
                //必须再次比较
                //前一个if入口的i++是因为当前i所指的元素就是换过来的小于
                //v的值，所以直接遍历下一个元素就行；
                // i++;
            }else{
                i++;
            }
        }
        //注意：这里的循环完成后，一定是gt指向小于v的最后一个区域；
        //所以这里可以直接交换l和gt的元素，然后返回gt 这个下标；
        swap(array,l,lt);
        return lt;
    }
    private static int partition(int[] array,int l,int r){
        //每次以第一个元素为分区点进行快排，
        //对一个近乎有序并且特别大的数列进行快排会发生栈溢出
        //因为栈内存不够用，递归不下去了；
        int randomIndex = (int) ((Math.random()*(r-l+1))+l);
        swap(array,l,randomIndex);
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


    private static int partition2(int[] data,int left,int right){

        int i = left+1;
        int j = right;
        int value = data[left];
        while(i <= j){
            while(data[i] < value){
                i++;
            }
            while(data[j] > value){
                j--;
            }
            if (i > j){
                break;
            }
            swap(data,i,j);
            i++;
            j--;
        }
        swap(data,left,j);
        return j;
    }

    /**
     * 交换元素
     * @param array
     * @param l
     * @param r
     */
    private static void swap(int[] array,int l,int r){
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void mergeSort(int[] array){
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1){
            return;
        }
        mergeInternal(array,0,n-1);
        long end = System.currentTimeMillis();
        System.out.println("归并排序耗时："+(end-start)+"毫秒");
    }
    private static void mergeInternal(int[] array,int low,int high){
        if (low >= high){
            return;
        }
        int mid = (low + high) / 2;
        //左边小数组
        mergeInternal(array,low,mid);
        //右边小数组
        mergeInternal(array,mid+1,high);
        //合并两个小数组
        merge(array,low,mid,high);
    }

    /**
     *
     * @param array  分开之前的大数组
     * @param p  两个小数组最左边的下标
     * @param q  两个小数组分割点元素
     * @param r  两个小数组最右边的下标
     */
    private static void merge(int[] array,int p,int m,int r){
        //把两个有序的数组合成大的有序数组，需要借助临时空间来解决
        //临时空间的大小等于两个小数组的长度之和；
        //i和j分别是两个小数组的起始点下标；
        int i = p;
        int j = m + 1;
        int[] temp = new int[r-p+1];
        int k = 0;
        //此时两个数组中均有元素
        while (i <= m && j <= r){
            if (array[i] <= array[j]){
                //此处加上等于号是为了保证稳定性；
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        //判断当前还有哪个数组元素没有走完；
        int start = i;
        int end = m;
        if (j <= r){
            start = j;
            end = r;
        }
        //把剩余元素直接放在temp数组后即可
        while (start <= end){
            temp[k++] = array[start++];
        }
        //然后将临时空间中已经合并好的元素拷贝回原数组；
        for (i = 0;i < r-p+1;i++){
            array[p+i] = temp[i];
        }
    }
}

