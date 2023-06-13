import bean.Car;
import bean.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ● @author: YiHui
 * ● @date: Created in 22:58  2023/4/25
 */

public class ApplicationContextTest {
    @Test
    public void testApplicationContext(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        //name属性在CustomBeanFactoryPostProcessor中被修改为YiHuiComeOn
        System.out.println(person);

        Car car = applicationContext.getBean("car", Car.class);
        //brand属性在CustomerBeanPostProcessor中被修改为Maserati
        System.out.println(car);
    }
}
