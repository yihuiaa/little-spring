package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:57  2023/2/17
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    Object getBean(String name,Object args[]);

    /**
     * 根据名称和类型查找bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
