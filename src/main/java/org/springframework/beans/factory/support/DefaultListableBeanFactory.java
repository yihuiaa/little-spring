package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.*;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:54  2023/2/20
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements
    ConfigurableListableBeanFactory,BeanDefinitionRegistry{
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    @Override public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = this.beanDefinitions.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' found in " + this);
        }
        return beanDefinition;
    }

    @Override public void preInstantiateSingletons() throws BeansException {
        beanDefinitions.keySet().forEach(this::getBean);
    }

    @Override public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitions.put(beanName, beanDefinition);
    }

    @Override public boolean containsBeanDefinition(String beanName) {
        return beanDefinitions.containsKey(beanName);
    }

    @Override public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitions.forEach((beanName,beanDefinition) -> {
            Class clazz = beanDefinition.getClazz();
            if(type.isAssignableFrom(clazz)){
                T bean = (T)getBean(beanName);
                result.put(beanName,bean);
            }
        });
        return result;
    }

    @Override public String[] getBeanDefinitionNames() {
        Set<String> beanNames = beanDefinitions.keySet();
        return beanNames.toArray(new String[beanNames.size()]);
    }
}
