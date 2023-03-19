import bean.Person;
import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:47  2023/3/19
 */
public class PropertyValuesTest {
    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        PropertyValue propertyValue1 = new PropertyValue("name", "zhangSan");
        PropertyValue propertyValue2 = new PropertyValue("age", 15);
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        factory.registerBeanDefinition("person", beanDefinition);
        Person person = (Person)factory.getBean("person");
        System.out.println(person);
    }
}
