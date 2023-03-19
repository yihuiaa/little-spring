package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:50  2023/2/20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
    @Override protected Object createBean(String name, BeanDefinition beanDefinition,Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(name,beanDefinition,args);
            //填充属性
            applyPropertyValues(name,bean, beanDefinition);
        }catch(Exception e){
            throw new BeansException("Fail to instantiation",e);
        }
        addSingleton(name,bean);
        return bean;
    }


    protected Object createBeanInstance(String name,BeanDefinition beanDefinition,Object[] args) throws Exception {
        Class clazz = beanDefinition.getClazz();
        Constructor constructor = null;
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            if(null!=args && c.getParameterCount() == args.length){
                constructor = c;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,constructor,args);
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            BeanUtil.setProperty(bean,name,value);
        }
    }

}
