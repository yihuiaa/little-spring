package common;

import bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ● @author: YiHui
 * ● @date: Created in 00:36  2023/4/18
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {
    @Override public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization");
        //换玛莎
        if("car".equals(beanName)){
            ((Car)bean).setName("Maserati");
        }
        return bean;
    }

    @Override public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization");
        return bean;
    }
}
