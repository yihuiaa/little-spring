package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.*;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:03  2023/2/20
 * ● @notes: 默认单例bean注册类
 */
public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap();
    private Map<String, DisposableBean> disposableBeans = new HashMap();

    @Override public Object getSingleton(String beanName) {
         return singletonObjects.get(beanName);
    }

    @Override public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons(){
        List<String> beanNameList = new ArrayList<>(disposableBeans.keySet());
        beanNameList.forEach(beanName ->{
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        });
    }

}
