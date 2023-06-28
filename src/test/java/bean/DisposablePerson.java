package bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.support.InitializingBean;

/**
 * ● @author: YiHui
 * ● @date: Created in 14:34  2023/6/28
 */
public class DisposablePerson extends Person implements DisposableBean, InitializingBean {
    @Override public void destroy() throws Exception {
        System.out.println("[ destroy ] ：哦天呐！我要被干了");
    }

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println("[ afterPropertiesSet ] :哦天呐！我被发现了");
    }

    public void customInitMethod() {
        System.out.println("customInitMethod : 我自己的初始化方法！");
    }

    public void customDestroyMethod() {
        System.out.println("customDestroyMethod： 我自己的销毁方法！");
    }
}
