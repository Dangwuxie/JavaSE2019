package Day13.Test;

public class Test3 {
    public static void main(String[] args) {
        int n = 9;
        int[][] data = new int[n][n];
        oddNumber(data,n);
        printMatrix(data,n);
    }
    public static void oddNumber(int data[][],int n){
        int num = 1;
        int p = n-1;
        int q = n/2;
        int temp = 0;
        while (temp < q){
            int x = temp;
            int y = temp;
            for (y = temp;y < p;y++){
                data[x][y] = num++;
            }
            for (x = temp;x < p;x++){
                data[x][y] = num++;
            }
            while (y != temp){
                data[x][y--] = num++;
            }
            while (x != temp){
                data[x--][y] = num++;
            }
            //此时两次while循环下来刚好数组下标x=y= ++temp;
            temp++;
            p = p - 1;
        }
        if ((n-1)%2 == 0){
            data[temp][temp] = n*n;
        }
    }
    public static void printMatrix(int data[][],int n){
        for (int x = 0;x < n;x++){
            for (int y = 0;y < n;y++){
                System.out.printf("%4d",data[x][y]);
            }
            System.out.println();
        }
    }
}
