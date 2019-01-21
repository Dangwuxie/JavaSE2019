package Day21.Test;

class Dog{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
class TaiDi extends Dog{
    private String country;
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
public class Test5 {
    public static void main(String[] args) {
        TaiDi taiDi = new TaiDi();
        taiDi.setAge(13);
        taiDi.setName("二哈");
        taiDi.setCountry("中国");
        System.out.println(taiDi.getName()+"来自"
            +taiDi.getCountry()+"  年龄"+taiDi.getAge());
    }
}
