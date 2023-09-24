package ioc;

import bean.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ● @author: YiHui
 * ● @date: Created in  2023/9/6
 */
public class PrototypeBeanTest {
	@Test
	public void testPrototype() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

		Car car1 = applicationContext.getBean("car", Car.class);
		Car car2 = applicationContext.getBean("car", Car.class);
		System.out.println(car1 == car2);;
	}
}
