package org.springframework.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;

/**
 *
 *
 /**
 * ● @author: YiHui
 * ● @date: Created in 11:58  2023/9/2
 * ● @notes: 实现该接口，能感知所属ApplicationContext
 */
public interface ApplicationContextAware extends Aware {

	void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
