package org.springframework.aop;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:32  2023/9/24
 * ● @Description: description
 */
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
