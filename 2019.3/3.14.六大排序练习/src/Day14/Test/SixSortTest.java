package Day14.Test;

public class SixSortTest {
    /**
     * 第一个冒泡排序；按照升序排列
     * @param data 传入要排序的数组
     */
    public static void bubbleSort(int[] data){
        int n = data.length;
        if (n <= 1){
            return;
        }
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n-1;j++){
                if (data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序：一组无序的数组，假定分为有序区和无序区，
     * 假设第一个元素是有序区，剩下的元素是无序区，
     * 然后从剩下的元素组里每次挑第一个元素插入到前面有序数列的
     * 合适位置从而不改变有序性
     * @param data
     */
    public static void insertSort(int[] data){
        int n = data.length;
        if (n <= 1){
            return;
        }
        //注意这里的i<n-1;循环条件，当i遍历到数组倒数第二个元素的时候
        //也就是说无序数列只剩下最后一个元素的时候，就是最后一次插入排序了
        //所以说i只能走到n-1这个下标；
        for (int i = 0;i < n-1;i++){
            //第一步循环，先找到要插入的位置
            int value = data[i+1];
            int j = i;
            while (j >= 0){
                if (data[j] > value){
                    j--;
                }else{
                    break;
                }
            }
            //找到要插入的位置为j+1下标；
            //然后把从j+1开始到i+1位置前面的额元素统一向后移动，
            //然后把i+1处的元素放到j+1处
            for (int p = i;p > j;p--){
                data[p+1] = data[p];
            }
            data[j+1] = value;
        }
    }


    /**
     * 二分插入排序：相比于直接插入排序，在寻找已排序区域合适位置的时候
     * 引入了二分查找法，就是每次和已排序数组最中间的元素比较，
     * 小的话继续在该元素左边的数组里的执行相同的步骤，直到只剩下一个元素；
     * @param data
     */
    public static void binaryInsertSort(int[] data){
        int n = data.length;
        if (n <= 1){
            return;
        }
        //老规矩，第一层循环，默认第一个元素为有序区
        //从i+1下标元素处开始跟有序区排序，寻找合适位置，
        //这次寻找合适位置的方法不再是从有序数列的最后一个元素向前遍历
        //而是使用二分查找的方法，寻找合适位置；
        for (int i = 0;i < n-1;i++){
            //内层循环第一步，二分查找法；
            //首先保存一下i+1元素，也就是乱序第一个元素，要插入的元素；
            int value = data[i+1];
            int left = 0;
            //i永远指向有序数列的最后一个元素；
            int right = i;
            while(left <= right){
                int mid = (left+right)/2;
                if (data[mid] < value){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            //while循环执行完后就可以找到要插入的位置了
            //要插入的位置为right+1下标处；
            //下面就是要把从right+1处开始的元素统一往后移动一个位置，
            //最后一个元素移动到i+1下标处，到此处截至；
            //下标开始移动元素；
            for (int j = i;j > right;j--){
                data[j+1] = data[j];
            }
            //移动完了之后，将该元素插入到合适位置
            data[right+1] = value;
        }
    }

    /**
     * 希尔排序法：核心思想就是采用分步的思想，就是说，
     * 每次循环都比较的是从第i个元素跟第i+(n/2）个元素，
     * 按照降序或者升序交换，循环的终止条件就是步伐是0的时候，
     * 就是自己跟自己比较的时候停止循环；
     * 它可以减少数据搬移的次数，排序的原则是将数据区分成特定间隔的几个小区块
     * 用插入排序法排完区块内的数据后再逐渐减少间隔的举例；
     * @param data
     */
    public static void shellSort(int[] data){
        //下面来实现一下代码
        //老规矩先判断传进来的数组长度是否合法；
        int n = data.length;
        if (n <= 1) {
            return;
        }
        //首先定义步伐的大小；
        int step = n/2;
        while(step >= 1){
            //这种循环是从0处的元素从前往后按照i+step比较
            /*for (int i = 0;i <= n-step-1;i++){
                if (data[i] > data[i+step]){
                    int temp = data[i];
                    data[i] = data[i+step];
                    data[i+step] = temp;
                }
            }*/

            //还有一种，从后往前遍历，不过我觉得不如前一种好
            for (int i = step;i < n;i++){
                int temp = data[i];
                int j = i - step;
                while(j >= 0 && temp<data[j]){
                    data[j+step] = data[j];
                    j = j-step;
                }
                data[j+step] = temp;
            }
            step /= 2;
        }

    }

    /**
     * 选择排序，也分未排序空间和已排序空间
     * 但是每次是将未排序空间最小的额元素放到已
     * 排序空间的最末尾，直到未排序空间元素个数为0；
     * @param data
     */
    public static void selectSort(int[] data){
        int n = data.length;
        if (n <= 1)return;;
        //下面直接开始循环，默认刚开始的数组元素是乱序的；
        for (int i = 0 ;i < n-1;i++){
            //先查找最小值；
            int minIndex = i;
            for (int j = i+1;j < n;j++){
                if (data[j] < data[i]){
                    //注意这里直接交换下标，
                    //所以minIndex一直指向的是最小元素的下标；
                    minIndex = j;
                }
            }
            //循环完了之后呢，交换到已排序空间的最后一个元素；
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            //这里注意，i一直指向已排序部分的最后一个元素；
            //就是要交换的哪个元素；
        }
    }
    /**
     * 输出排序后的数组；
     * @param data 要输出的数组；
     */

    public static void printArray(int[] data){
        for (int o:data) {
            System.out.print(o+" ");
        }
    }


}
