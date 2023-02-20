package org.springframework.beans;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:16  2023/2/20
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }
    public BeansException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
