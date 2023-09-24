package ioc;

import bean.Car;
import bean.Person;
import common.CustomBeanFactoryPostProcessor;
import common.CustomerBeanPostProcessor;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * ● @author: YiHui
 * ● @date: Created in 21:29  2023/4/17
 */
public class BeanFactoryProcessorAndBeanPostProcessorTest {

        @Test
        public void BeanFactoryPostProcessor() throws Exception {
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
            xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

            //BeanDefinition加载完成后，bean实例化之前，修改BeanDefinition的属性值
            CustomBeanFactoryPostProcessor beanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
            beanFactoryPostProcessor.postProcessBeanFactory(factory);

            Person person = (Person)factory.getBean("person");
            System.out.println(person);
        }
    @Test
    public void testBeanPostProcessor() throws Exception {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        //添加bean实例化后的处理器
        factory.addBeanPostProcessor(new CustomerBeanPostProcessor());

        Car car = (Car)factory.getBean("car");
        System.out.println(car);

    }
}
