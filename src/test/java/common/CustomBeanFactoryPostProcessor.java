package common;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * ● @author: YiHui
 * ● @date: Created in 00:33  2023/4/18
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        //修改name
        propertyValues.addPropertyValue(new PropertyValue("name","YiHuiComeOn"));
    }
}
