import java.util.Scanner;

/**
 * 机器人走方格；
 */
public class GoCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x + y > 12){
                return;
            }else {
                System.out.println(countWays(x, y));
            }
        }
    }
    public static int countWays(int x, int y){
        if (x == 1 || y == 1){
            return 1;
        }else{
            return countWays(x-1,y) + countWays(x,y-1);
        }
    }
}
