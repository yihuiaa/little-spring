package ioc;

import common.event.CustomEvent;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:45  2023/9/6
 */
public class EventAndEventListenerTest {
    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext));

        applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;
    }
}
