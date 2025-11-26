package org.springframework.aop;
/**
 * 被代理的目标对象
 * @author yihui
 */
public class TargetSource {
    /**
     * 不可变的目标对象引用
     */
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 返回目标对象实现的所有接口,为JDK动态代理提供接口信息
     */
    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }

}
