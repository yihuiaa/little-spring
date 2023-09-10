package common.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * ● @author: YiHui
 * ● @date: Created in   2023/9/10
 * ● @notes：自定义事件
 */
public class CustomEvent extends ApplicationContextEvent {
	public CustomEvent(ApplicationContext source) {
		super(source);
	}
}
