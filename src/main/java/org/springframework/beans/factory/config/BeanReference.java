package org.springframework.beans.factory.config;

/**
 * ● @author: YiHui
 * ● @date: Created in 22:05  2023/3/20
 */
public class BeanReference {
    private String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
