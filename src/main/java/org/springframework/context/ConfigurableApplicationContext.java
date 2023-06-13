package org.springframework.context;

import org.springframework.beans.BeansException;

/**
 * ● @author: YiHui
 * ● @date: Created in 21:41  2023/4/26
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
