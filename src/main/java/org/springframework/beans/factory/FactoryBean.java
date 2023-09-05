package org.springframework.beans.factory;

/**
 * ● @author: YiHui
 * ● @date: Created in 14:34  2023/9/5
 */
public interface FactoryBean<T> {

	T getObject() throws Exception;

	boolean isSingleton();
}
