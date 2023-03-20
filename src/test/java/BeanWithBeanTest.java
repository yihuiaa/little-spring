import bean.Car;
import bean.Person;
import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * ● @author: YiHui
 * ● @date: Created in 22:11  2023/3/20
 */
public class BeanWithBeanTest {
    @Test
    public void testBeanWithBean(){
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name","yiHui"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age",20));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car",new BeanReference("car")));

        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("name","Rolls-Royce"));

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("car",new BeanDefinition(Car.class,propertyValuesForCar));
        factory.registerBeanDefinition("person",new BeanDefinition(Person.class,propertyValuesForPerson));

        Person person = (Person)factory.getBean("person");
        System.out.println(person);
    }
}
