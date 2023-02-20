package org.springframework.beans.factory.config;

/**
 * ● @author: YiHui
 * ● @date: Created in 15:54  2023/2/20
 */
public class BeanDefinition {
    private Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
