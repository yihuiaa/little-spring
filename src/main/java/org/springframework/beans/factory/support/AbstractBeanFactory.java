package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:20  2023/2/20
 * ● @notes:抽象bean工厂，提供获取bean的模版方法
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 模板方法
     * @param name
     * @return
     * @throws BeansException
     */
    @Override public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if(bean!=null){return bean;}
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String name,BeanDefinition beanDefinition);

}
