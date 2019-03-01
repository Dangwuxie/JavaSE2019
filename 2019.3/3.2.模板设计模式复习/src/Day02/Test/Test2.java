package Day02.Test;

import java.util.Scanner;

abstract class CaffeineBeverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()){
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();
    public void boilWater(){
        System.out.println("烧开水");
    }
    public void pourInCup(){
        System.out.println("倒入杯中");
    }
    boolean customerWantsCondiments(){
        return true;
    }
}
class Tea2 extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("放入茶包");
    }

    @Override
    void addCondiments() {
        System.out.println("加入调料");
    }
}
class Coffee2 extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("倒入咖啡粉");
    }
    @Override
    void addCondiments() {
        System.out.println("加入调料");
    }

    @Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.equals("y")){
            return true;
        }else{
            return false;
        }
    }
    private String getUserInput(){
        String answer = null;
        System.out.println("加牛奶或者咖啡码？(y/n)");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}
public class Test2 {
    public static void main(String[] args) {
        new Coffee2().prepareRecipe();
    }
}
