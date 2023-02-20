package org.springframework.beans.factory.config;

/**
 * ● @author: YiHui
 * ● @date: Created in 15:56  2023/2/20
 * ● @notes:单例bean注册接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
    void addSingleton(String beanName, Object singletonObject);

}
