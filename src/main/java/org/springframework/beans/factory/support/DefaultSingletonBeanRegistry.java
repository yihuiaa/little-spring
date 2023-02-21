package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:03  2023/2/20
 * ● @notes: 默认单例bean注册类
 */
public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap();

    @Override public Object getSingleton(String beanName) {
         return singletonObjects.get(beanName);
    }

    @Override public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
