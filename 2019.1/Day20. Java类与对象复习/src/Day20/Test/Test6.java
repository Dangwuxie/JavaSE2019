package Day20.Test;

import java.util.Arrays;

class SuperMan{
    public static String country;
    public String name;
    public int age;
    public SuperMan(String country,String name,int age){
        this.age = age;
        this.name = name;
        this.country = country;
    }
    public void printInFo(){
        System.out.println("姓名:"+this.name+" 来自:"+this.country+" 年龄："+this.age);
    }
}
public class Test6 {
    public static void main(String[] args) {
        SuperMan superMan1 = new SuperMan("美国","雷神",100);
        SuperMan superMan2 = new SuperMan("英国","钢铁侠",55);
        SuperMan superMan3 = new SuperMan("法国","蚁人",44);
        SuperMan.country = "美利坚合众国";
        superMan1.printInFo();
        superMan2.printInFo();
        superMan3.printInFo();
    }
}
