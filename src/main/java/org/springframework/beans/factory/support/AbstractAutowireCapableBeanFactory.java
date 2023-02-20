package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:50  2023/2/20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override protected Object createBean(String name, BeanDefinition beanDefinition) {
        return doCreateBean(name,beanDefinition);
    }
    protected Object doCreateBean(String name,BeanDefinition beanDefinition){
        Class clazz = beanDefinition.getClazz();
        Object bean = null;
        try {
            bean = clazz.newInstance();
        }catch (Exception e) {
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(name,bean);
        return bean;
    }
}
