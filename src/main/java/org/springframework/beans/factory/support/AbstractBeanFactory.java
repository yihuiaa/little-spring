package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:20  2023/2/20
 * ● @notes:抽象bean工厂，提供获取bean的模版方法
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();
    /**
     * 模板方法
     * @param name
     * @return
     * @throws BeansException
     */
    @Override public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override public Object getBean(String name, Object... args) {
        return doGetBean(name,args);
    }

    protected Object doGetBean(String name,Object... args) throws BeansException{
        Object sharedInstance = getSingleton(name);
        if(sharedInstance!=null){
            //如果是FactoryBean，从FactoryBean#getObject中创建bean
            return getObjectForBeanInstance(sharedInstance,name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return getObjectForBeanInstance(bean,name);
    }

    /**
     *
     * @param sharedInstance
     * @param beanName
     * @return
     */
    private Object getObjectForBeanInstance(Object sharedInstance, String beanName){
        Object obj = sharedInstance;
        if(sharedInstance instanceof FactoryBean){
            try {
                FactoryBean factoryBean = (FactoryBean<?>)sharedInstance;
                if(((FactoryBean<?>)sharedInstance).isSingleton()){
                    //singleton作用域bean，从缓存中获取
                    obj = this.factoryBeanObjectCache.get(beanName);
                    if( obj == null ){
                        obj  =  factoryBean.getObject();
                        this.factoryBeanObjectCache.put(beanName, obj);
                    }
                }else{
                    //prototype作用域bean，新创建bean
                    obj  =  factoryBean.getObject();
                }
            }catch (Exception e){
                throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
            }
        }
        return obj;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String name,BeanDefinition beanDefinition,Object[] args);

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        //有则覆盖
        beanPostProcessors.remove(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    @Override public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T)getBean(name);
    }
}
