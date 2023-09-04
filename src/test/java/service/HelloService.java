package service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ● @author: YiHui
 * ● @date: Created in 11:46  2023/9/2
 */
public class HelloService implements ApplicationContextAware, BeanFactoryAware {
    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;
   public String hello() {
        System.out.println("hello word!");
        return "hello word!";
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory    = beanFactory;
    }

    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
