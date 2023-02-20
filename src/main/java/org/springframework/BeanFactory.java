package org.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:57  2023/2/17
 */
public class BeanFactory {
    private Map<String,Object> beanContext = new HashMap<>();
    public Object getBean(String name){
        return beanContext.get(name);
    }

    /**
     *  所谓注册bean,就是将bean放入容器
     * @param name
     * @param bean
     */
    public void registerBean(String name,Object bean){
        beanContext.put(name,bean);
    }
}
