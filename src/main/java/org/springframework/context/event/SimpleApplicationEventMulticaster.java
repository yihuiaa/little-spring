package org.springframework.context.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.SimpleInstantiationStrategy;
import org.springframework.context.support.ApplicationListener;
import org.springframework.context.ApplicationEvent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:12  2023/9/10
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    /**
     * 创建一个 SimpleApplicationEventMulticaster 实例，并指定用于查找监听器的 BeanFactory。
     *
     * @param beanFactory 用于查找监听器的 BeanFactory
     */
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    /**
     * 广播给定的应用程序事件到所有注册的监听器。
     * @param event 要多播的应用程序事件
     */
    @Override public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener<org.springframework.context.ApplicationEvent> listener : applicationListeners) {
            if(supportsEvent(listener,event)){
                listener.onApplicationEvent(event);
            }
        }
    }

    /**
     * 检查监听器是否对给定的事件感兴趣。
     *
     * @param applicationListener 要检查的监听器
     * @param event              要检查的事件
     * @return 如果监听器支持处理事件，则返回 true，否则返回 false
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        //适用于简单实例化策略SimpleInstantiationStrategy
        //todo 有兴趣的同学可以完善cglib的实例化方法加以适配
        //获取泛型接口
        Type genericInterfaceType = applicationListener.getClass().getGenericInterfaces()[0];
        // 获取泛型接口中的实际类型参数，也就是是事件的类型
        Type actualTypeArgument = ((ParameterizedType)genericInterfaceType).getActualTypeArguments()[0];


        //事件名称
        String eventClassName = actualTypeArgument.getTypeName();
        Class<?> eventClass;
            try {
                eventClass = Class.forName(eventClassName);
            }catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + eventClassName);
        }
        // 检查事件是否是监听器支持的类型
        // 如果事件类是监听器泛型参数的子类或实现类，则返回 true，表示监听器支持处理此事件
        return eventClass.isAssignableFrom(event.getClass());
    }

}
