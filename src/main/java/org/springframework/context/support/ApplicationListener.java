package org.springframework.context.support;

import org.springframework.context.ApplicationEvent;

/**
 * ● @author: YiHui
 * ● @date: Created in 12:00  2023/9/8
 */
public interface ApplicationListener<E extends ApplicationEvent> {
    /**
     * 观察者的响应方法
     * @param event
     */
    void onApplicationEvent(E event);
}
