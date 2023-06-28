package org.springframework.beans.factory.support;

/**
 * ● @author: YiHui
 * ● @date: Created in 14:39  2023/6/28
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
