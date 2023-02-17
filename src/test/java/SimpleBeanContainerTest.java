import org.springframework.BeanFactory;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:58  2023/2/17
 */
public class SimpleBeanContainerTest {
    public  void test(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("userService", new UserService());
        UserService userService = (UserService)beanFactory.getBean("userService") ;
        userService.sayHello();
    }
    class UserService{
        public void sayHello(){
            System.out.println("helloWord");
        }
    }

}
