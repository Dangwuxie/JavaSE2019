package Day20.Test;

public class Test5 {
    public static void main(String[] args) {
        int[][] arr5 = new int[][]
        {
                {1,2,3},
                {4,5},
                {6,7,8,9}
        };
        for (int x = 0;x < arr5.length;x++){
            for (int y = 0;y <arr5[x].length;y++){
                System.out.print(arr5[x][y]+"、");
            }
            System.out.println();
        }
    }
}
