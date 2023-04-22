package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:50  2023/2/20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements
    AutowireCapableBeanFactory {
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
            //执行bean的初始化方法和BeanPostProcessor的前置和后置处理方法
            initializeBean(name, bean, beanDefinition);
        }catch(Exception e){
            throw new BeansException("Fail to instantiation",e);
        }
        addSingleton(name,bean);
        return bean;
    }

    protected Object initializeBean(String beanName, Object bean,BeanDefinition beanDefinition){
        //执行BeanPostProcessor的前置处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // todo 执行bean初始化
        invokeInitMethods(beanName,bean, beanDefinition);
        //执行BeanPostProcessor的后置处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
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
            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference)value;
                value = getBean(beanReference.getName());
            }
            BeanUtil.setProperty(bean,name,value);
        }
    }

    @Override public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
        throws BeansException {
        Object result = existingBean;
        for(BeanPostProcessor beanPostProcessor : getBeanPostProcessors()){
            Object current = beanPostProcessor.postProcessBeforeInitialization(existingBean,beanName);
            if(current == null){
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
        throws BeansException {
        Object result = existingBean;
        for(BeanPostProcessor beanPostProcessor : getBeanPostProcessors()){
            Object current = beanPostProcessor.postProcessAfterInitialization(existingBean,beanName);
            if(current ==null){
                return result;
            }
            result = current;
        }
        return result;
    }
    /**
     * 执行bean的初始化方法
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @throws Throwable
     */
    protected void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) {
        //TODO 后面会实现
        System.out.println("执行bean[" + beanName + "]的初始化方法");
    }
}
