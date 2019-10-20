package dxc.算法.模板;

/**
 * @author 灵魂编程者
 * @Title: RandomNumber
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/13 17:07
 */
public class RandomNumber {

    public static void main(String[] args) {
        /*
        * 总是产生[0,19)之间的整数
        * */
        for (int i=0;i<100;i++){
            System.out.print((int) ((19)*Math.random())+" ");
        }
    }
    /*
    * 假设size的长度就是数组的大小
    * value就是索要生成数组的元素的范围
    * 随机生成一个指定长度的数组
    * */
    public static int[] randomArray(int size,int value){
        int[] arr = new int[size];
        System.out.println(arr.length);
        for (int i=0;i<arr.length;i++){
            arr[i] = (int) ((value+1)*Math.random());
        }
        return arr;
    }

    /*
    * 直接返回一个固定长度内随机长度、固定范围随机长度的数组
    * */
    public static int[] randomArray2(int size,int value){
        int[] arr = new int[(int) ((size+1)*Math.random())];
        System.out.println(arr.length);
        for (int i=0;i<arr.length;i++){
            arr[i] = (int) ((value+1)*Math.random());
        }
        return arr;
    }
}
