package org.springframework.beans.support;

import org.springframework.beans.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:03  2023/2/20
 * ● @notes: 默认单例bean注册类
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap();

    @Override public Object getSingleton(String beanName) {
         return singletonObjects.get(beanName);
    }

    @Override public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
