package bean;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:46  2023/3/19
 */
public class Person {
    private String name;
    private String age;
    private Car car;

    public Person(String name, String age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", car=" + car + '}';
    }
}
