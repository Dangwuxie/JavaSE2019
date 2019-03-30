package Day26.Test;


public class Test1 {

    public static void main(String[] args) {
	// write your code here
        Class<?> cls = Test1.class;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());

    }
}
