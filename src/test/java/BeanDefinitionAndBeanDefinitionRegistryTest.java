import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:58  2023/2/17
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {
    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClazz(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService") ;
        userService.save();
    }
}
