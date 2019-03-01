package Day02.Test;

class Coffee{
    void prepareRecipe(){
        boilwater();
        brewCoffee();
        pourInCup();
        addSugarAndMilk();
    }
    public void boilwater(){
        System.out.println("烧开水");
    }
    public void brewCoffee(){
        System.out.println("倒入咖啡");
    }
    public void pourInCup(){
        System.out.println("将水倒入杯中");
    }
    public void addSugarAndMilk(){
        System.out.println("加糖或者奶茶");
    }
}
class Tea{
    void prepareRecipe(){
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }
    public void boilWater(){
        System.out.println("烧开水");
    }
    public void steepTeaBag(){
        System.out.println("放入茶包");
    }
    public void pourInCup(){
        System.out.println("将水倒入杯中");
    }
    public void addLemon(){
        System.out.println("加柠檬");
    }
}
public class Test1 {

    public static void main(String[] args) {
        new Coffee().prepareRecipe();
        new Tea().prepareRecipe();
    }
}
