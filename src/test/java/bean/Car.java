package bean;

/**
 * ● @author: YiHui
 * ● @date: Created in 22:10  2023/3/20
 */
public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "Car{" + "name='" + name + '\'' + '}';
    }
}
