package org.springframework.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ApplicationListener;

/**
 * ● @author: YiHui
 * ● @date: Created in  2023/9/6
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(ApplicationListener<?> listener);

	void removeApplicationListener(ApplicationListener<?> listener);

	void multicastEvent(ApplicationEvent event);

}
