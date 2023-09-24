package ioc;

import bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * ● @author: YiHui
 * ● @date: Created in 18:36  2023/4/8
 */
public class XmlFileDefineBeanTest {
    @Test
    public void testXmlFileDefine(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) factory.getBean("person");
        System.out.println(person);
    }
}
