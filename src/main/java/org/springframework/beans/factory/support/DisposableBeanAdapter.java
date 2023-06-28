package org.springframework.beans.factory.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;

import java.lang.reflect.Method;

/**
 * ● @author: YiHui
 * ● @date: Created in 16:21  2023/6/25
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, String destroyMethodName) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = destroyMethodName;
    }

    @Override public void destroy() throws Exception {
        if(bean instanceof DisposableBean){
            ((DisposableBean)bean).destroy();
        }
        //DisposableBean的自定义的销毁方法命名为destroy时避免重复执行
        if(StrUtil.isNotEmpty(destroyMethodName) && !((bean instanceof DisposableBean) && destroyMethodName.equals("destroy"))){
            Method destroyMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
            if(destroyMethod == null){
                throw new BeansException("Could not find destroy method [" + destroyMethodName + "] on bean [" + beanName + "]");
            }
            destroyMethod.invoke(bean);
        }
    }


}
