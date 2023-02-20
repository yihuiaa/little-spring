package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:54  2023/2/20
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    @Override protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = this.beanDefinitions.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' found in " + this);
        }
        return beanDefinition;
    }

    @Override public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitions.put(beanName, beanDefinition);
    }
}
