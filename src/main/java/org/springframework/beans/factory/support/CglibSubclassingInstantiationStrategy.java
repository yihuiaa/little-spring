package org.springframework.beans.factory.support;

import net.sf.cglib.proxy.NoOp;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import net.sf.cglib.proxy.Enhancer;
/**
 * ● @author: YiHui
 * ● @date: Created in 13:56  2023/2/21
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override public Object instantiate(BeanDefinition beanDefinition, Constructor constructor, Object[] args)
        throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getClazz());
        enhancer.setCallback(new NoOp() {
            @Override public int hashCode() {
                return super.hashCode();
            }
        });
        if(null == constructor) return enhancer.create();
        return enhancer.create(constructor.getParameterTypes(),args);
    }
}
