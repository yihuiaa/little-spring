import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ● @author: YiHui
 * ● @date: Created in 14:47  2023/6/28
 */
public class InitAndDestroyMethodTest {
    @Test
    public void initAndDestroyMethodTest() {
     ClassPathXmlApplicationContext applicationContext =
         new ClassPathXmlApplicationContext("classpath:spring.xml");
         applicationContext.registerShutdownHook();  //或者手动关闭 applicationContext.close();
    }
}
