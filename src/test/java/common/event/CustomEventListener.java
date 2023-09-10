package common.event;

import org.springframework.context.support.ApplicationListener;

/**
 * ● @author: YiHui
 * ● @date: Created in   2023/9/10
 * ● @notes: 自定义事件监听器
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent event) {

		System.out.println(this.getClass().getName()+ "：：我听到了-自定义监听器-开始执行我的事件");
	}
}
