package Day28.Test;

//内部类实现多继承；
class A{
    private String name = "A类的私有域";
    public String getName() {
        return name;
    }
}
class B{
    private int age = 666;
    public int getAge() {
        return age;
    }
}
class Outer4{
    private class InnerClassA extends A{
        public String name(){
            return super.getName();
        }
    }
    private class InnerClassB extends B{
        public int age(){
            return super.getAge();
        }
    }
    public String name(){
        return new InnerClassA().name();
    }
    public int age(){
        return new InnerClassB().age();
    }
}
public class Test4 {
    public static void main(String[] args) {
        Outer4 outer4 = new Outer4();
        System.out.println(outer4.age());
        System.out.println(outer4.name());
    }
}
