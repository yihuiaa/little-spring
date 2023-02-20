package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:57  2023/2/17
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
