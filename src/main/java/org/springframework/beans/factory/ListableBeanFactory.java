package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

import java.util.Map;

/**
 * ● @author: YiHui
 * ● @date: Created in 21:41  2023/4/17
 * ● @notes: 一些获取容器中bean信息的方法
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
