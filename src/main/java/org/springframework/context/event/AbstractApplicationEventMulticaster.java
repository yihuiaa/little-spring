package org.springframework.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.support.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

/**
 * ● @author: YiHui
 * ● @date: Created in 15:35  2023/9/10
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    /**
     * 监听器集合，相当于观察者模式中的观察者列表
     */
    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;
    @Override public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<org.springframework.context.ApplicationEvent>) listener);
    }

    @Override public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }
}
