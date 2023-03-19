package org.springframework.beans;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:23  2023/3/19
 */
public class PropertyValue {
    //属性名
    private final String name;
    //属性值
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
