package org.springframework.aop;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:47  2023/9/24
 * ● @Description: description
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
