package Day05.Test;

import java.util.Scanner;
//简单工厂模式：把实例化单独封装到一个类里；
interface Computer2{
    /**
     * 产品抽象类；
     */
    void realBuyComputer();
}
class MacBook2 implements Computer2{
    @Override
    public void realBuyComputer() {
        System.out.println("买一台MACBOOK笔记本");
    }
}
class AlienBook2 implements Computer2{
    @Override
    public void realBuyComputer() {
        System.out.println("买一台AlienBook笔记本");
    }
}
class SurfaceBook2 implements Computer2{
    @Override
    public void realBuyComputer() {
        System.out.println("买一台SurfaceBook笔记本");
    }
}
class RealBuyComputer{
    /**
     * 此类就是工厂
     * @param answer
     * @return
     */
    public static Computer2 fun(String answer){
        if (answer.equals("mac")){
            return new MacBook2();
        }else if (answer.equals("sur")){
            return new SurfaceBook2();
        }else if (answer.equals("ali")){
            return new AlienBook2();
        }else {
            return null;
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        String answer;
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        Computer2 computer2 = RealBuyComputer.fun(answer);
        computer2.realBuyComputer();

    }
}
