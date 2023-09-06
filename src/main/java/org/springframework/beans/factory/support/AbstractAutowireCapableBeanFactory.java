package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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
            bean = createBeanInstance(beanDefinition,args);
            //填充属性
            applyPropertyValues(bean, beanDefinition);
            //执行bean的初始化方法和BeanPostProcessor的前置和后置处理方法
            initializeBean(name, bean, beanDefinition);
        }catch(Exception e){
            throw new BeansException("Fail to instantiation",e);
        }
        //注册有销毁方法的bean
        registerDisposableBeanIfNecessary(name, bean, beanDefinition);
        if(beanDefinition.isSingleton()){
            addSingleton(name,bean);
        }
        return bean;
    }

    protected Object initializeBean(String beanName, Object bean,BeanDefinition beanDefinition){
        if(bean instanceof BeanFactoryAware){
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }
        //执行BeanPostProcessor的前置处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception ex) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", ex);
        }
        //执行BeanPostProcessor的后置处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }
    protected Object createBeanInstance(BeanDefinition beanDefinition,Object[] args) throws Exception {
        Class<?> clazz = beanDefinition.getClazz();
        Constructor<?> constructor = null;
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor<?> c : constructors){
            if(null!=args && c.getParameterCount() == args.length){
                constructor = c;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,constructor,args);
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) {
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

    /**
     * 支持注册有销毁方法的bean(即继承自DisposableBean或有自定义的销毁方法并在xml定义的Bean)
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void registerDisposableBeanIfNecessary(String beanName,Object  bean,BeanDefinition beanDefinition) {
        if(beanDefinition.isSingleton()) {
            if(bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
                registerDisposableBean(beanName,new DisposableBeanAdapter(bean, beanName,beanDefinition.getDestroyMethodName()));
            }
        }
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
    protected void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        if(bean instanceof InitializingBean){
            ((InitializingBean)bean).afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();
        if(StrUtil.isNotEmpty(initMethodName)){
            Method initMethod = ClassUtil.getPublicMethod(bean.getClass(), initMethodName);
            if(initMethod == null){
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(bean);
        }
    }
}
