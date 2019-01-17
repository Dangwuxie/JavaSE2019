package Day17.Test;

import java.util.Objects;

class Person{
    private String name;
    private int agg;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return agg == person.agg &&
                Objects.equals(name, person.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgg() {
        return agg;
    }

    public void setAgg(int agg) {
        this.agg = agg;
    }
}
class Student{

}
public class Test6 {
}
