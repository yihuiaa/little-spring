package org.springframework.beans.factory;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:10  2023/6/25
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
