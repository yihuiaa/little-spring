import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HelloService;


/**
 * ● @author: YiHui
 * ● @date: Created in 11:46  2023/9/2
 */

public class AwareInterfaceTest {

	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
		HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
		System.out.println("ApplicationContext: "+helloService.getApplicationContext());
		System.out.println("BeanFactory: "+helloService.getBeanFactory());
	}
}
