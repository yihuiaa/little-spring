package org.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Spring AOP核心配置类
 * @author yihui
 */
public class AdvisedSupport {
    /**
     * 目标对象源
     * 封装被代理的目标对象。TargetSource是一个接口，可以返回需要被AOP增强的目标对象实例。
     */
    private TargetSource targetSource;

    /**
     * 方法拦截器
     * 定义具体的增强逻辑，这是AOP Alliance标准接口的实现。
     */
    private MethodInterceptor methodInterceptor;

    /**
     * 方法匹配器
     * 决定哪些方法需要被拦截，实现"切点"的概念。
     */
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
