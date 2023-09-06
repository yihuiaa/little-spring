package org.springframework.beans.factory.config;

import org.springframework.beans.PropertyValues;

/**
 * ● @author: YiHui
 * ● @date: Created in 15:54  2023/2/20
 */
public class BeanDefinition {
    private Class<?> clazz;
    private PropertyValues propertyValues;
    private String initMethodName;

    private String destroyMethodName;


    private String scope = SCOPE_SINGLETON;

    private boolean singleton = true;

    private boolean prototype = false;

    public static String SCOPE_SINGLETON = "singleton";

    public static String SCOPE_PROTOTYPE = "prototype";

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public BeanDefinition() {
    }

    public BeanDefinition(Class<?> clazz) {
        this(clazz, null);
    }

    public BeanDefinition(Class<?> clazz, PropertyValues propertyValues) {
        this.clazz = clazz;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
