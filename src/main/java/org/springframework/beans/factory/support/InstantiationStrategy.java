package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * ● @author: YiHui
 * ● @date: Created in 11:35  2023/2/21
 * ● @Description:bean实例化策略接口
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws Exception;
}
