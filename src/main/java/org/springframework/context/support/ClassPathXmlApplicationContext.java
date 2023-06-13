package org.springframework.context.support;


/**
 * ● @author: YiHui
 * ● @date: Created in 22:00  2023/6/5
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    /**
     * 从xml文件中加载BeanDefinition，并自动刷新上下文
     * @param configLocations
     */
    public ClassPathXmlApplicationContext(String configLocations) {
        this(new String[]{configLocations});
    }

    /**
     *
     * @param configLocations
     */
    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }



    @Override public String[] getBeanDefinitionNames() {
        return new String[0];
    }

    public String[] getConfigLocations() {
        return configLocations;
    }
}
