package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * ● @author: YiHui
 * ● @date: Created in 11:58  2023/9/2
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
