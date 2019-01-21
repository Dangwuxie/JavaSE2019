package Day21.Test;
class China{
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Shanxi extends China{
    private String name2;
    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
}
class Baoji extends Shanxi{
    private String name3;
    public String getName3() {
        return name3;
    }
    public void setName3(String name3) {
        this.name3 = name3;
    }
}
public class Test6 {
    public static void main(String[] args) {
        Baoji baoji = new Baoji();
        baoji.setName("中国");
        baoji.setName2("陕西");
        baoji.setName3("宝鸡");
        System.out.println(baoji.getName()+" "
        +baoji.getName2()+" "+baoji.getName3());
    }
}
