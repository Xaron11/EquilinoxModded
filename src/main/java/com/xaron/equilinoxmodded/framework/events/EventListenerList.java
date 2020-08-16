package com.xaron.equilinoxmodded.framework.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventListenerList {
	
	private final Map<Method, Object> listeners = new HashMap<Method, Object>();
	
	protected void addListener(Object instance, Method listener) {
		listeners.put(listener, instance);
	}
	
	protected void invoke(Object event)
	{
		for (Method listener : listeners.keySet()) {
			try {
				listener.invoke(listeners.get(listener), event);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.out.println("exception");
				e.printStackTrace();
			}
		}
	}
}
