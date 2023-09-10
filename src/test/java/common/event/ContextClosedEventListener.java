package common.event;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.ApplicationListener;

/**
 * ● @author: YiHui
 * ● @date: Created in   2023/9/10
 * ● @notes: 容器关闭事件监听器
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		System.out.println(this.getClass().getName()+ "：：我听到了-容器关闭了-开始执行ContextClosedEvent");
	}
}
