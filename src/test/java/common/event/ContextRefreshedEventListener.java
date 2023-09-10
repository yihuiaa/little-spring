package common.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ApplicationListener;

/**
 * ● @author: YiHui
 * ● @date: Created in   2023/9/10
 * ● @notes: 容器刷新事件监听器
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println(this.getClass().getName()+ "：：我听到了-容器刷新了-开始执行ContextRefreshedEvent");
	}
}
