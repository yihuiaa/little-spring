package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author yihui
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    /**
     *  代理对象创建
     */
    @Override
    public Object getProxy() {
        // JDK动态代理的标准用法
        return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource().getTargetClass(), this);
    }

    /**
     * 方法调用拦截
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //策略模式 根据MethodMatcher的匹配结果决定执行策略
        if (advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
            // 匹配的方法：执行AOP拦截逻辑
            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
        }
        // 不匹配的方法：直接调用目标方法
        return method.invoke(advised.getTargetSource().getTarget(), args);
    }
}
