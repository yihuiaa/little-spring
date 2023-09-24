package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:36  2023/9/24
 * ● @Description: description
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
