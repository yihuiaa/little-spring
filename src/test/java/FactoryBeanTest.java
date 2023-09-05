import bean.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FactoryBeanTest {
	@Test
	public void testFactoryBean(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");
		Person person = applicationContext.getBean("person", Person.class);
		System.out.println(person);
	}
}
