package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * ● @author: YiHui
 * ● @date: Created in 13:53  2023/2/21
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override public Object instantiate(BeanDefinition beanDefinition, Constructor ctor, Object[] args)
        throws BeansException {
        Class clazz = beanDefinition.getClazz();
        try {
            if(null != ctor){
                return ctor.newInstance(args);
                //                return clazz.getConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.newInstance();
            }
        }catch (ReflectiveOperationException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]",e);
        }

    }
}
