package org.springframework.context.event;

import org.springframework.context.ApplicationContext;


public class ContextClosedEvent extends ApplicationContextEvent {

	public ContextClosedEvent(ApplicationContext source) {
		super(source);
	}
}
