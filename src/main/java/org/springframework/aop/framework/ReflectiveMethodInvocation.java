package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;


/**
 * @author yihui
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    /**
     * 目标对象引用
     */
    private final Object target;

    /**
     * 方法元数据
     * 封装被调用方法的反射信息
     */
    private final Method method;

    /**
     * 方法参数
     * 存储方法调用时的实际参数值
     */
    private final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    /**
     * 方法执行核心
     */
    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
