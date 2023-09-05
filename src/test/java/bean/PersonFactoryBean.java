package bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * ● @author: YiHui
 * ● @date: Created in 18:24  2023/9/5
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    private  String name;

    @Override public Person getObject()  {
        Person person = new Person();
        person.setName("YiHuiComeOn");
        person.setAge("18");
        return person;
    }
    @Override public boolean isSingleton() {
        return true;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
