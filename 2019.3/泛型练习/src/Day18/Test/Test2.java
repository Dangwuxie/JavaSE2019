package Day18.Test;

//通配符练习

class Person<T>{
    T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
public class Test2 {
    public static void main(String[] args) {
        Person<String> person1 = new Person<>();
        person1.setT("hello");
        print(person1);
        Person<Integer> person2 = new Person<>();
        person2.setT(6666);
        print(person2);
    }
    public static void print(Person<?> st){

        System.out.println(st.getT());
    }

}
