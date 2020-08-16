package com.xaron.equilinoxmodded.framework.events;

import java.lang.reflect.Method;

import com.xaron.equilinoxmodded.framework.Entity;
import com.xaron.equilinoxmodded.framework.Session;

public class EventBus {
	
	public enum Events {
		INITIALIZATION {
			private EventListenerList event = new EventListenerList();
			@Override
			public void invoke(Object object) {
				event.invoke(new InitializationEvent());
			}
			@Override
			public void addListener(Object instance, Method method) {
				event.addListener(instance, method);
			}
		},
		SESSION_LOADED {
			private EventListenerList event = new EventListenerList();
			@Override
			public void invoke(Object object) {
				event.invoke(new SessionLoadedEvent((Session)object));
			}
			@Override
			public void addListener(Object instance, Method method) {
				event.addListener(instance, method);
			}
		},
		SESSION_INITIALIZED {
			private EventListenerList event = new EventListenerList();
			@Override
			public void invoke(Object object) {
				event.invoke(new SessionInitializedEvent((Session)object));
			}
			@Override
			public void addListener(Object instance, Method method) {
				event.addListener(instance, method);
			}
		},
		GAME_UPDATE {
			private EventListenerList event = new EventListenerList();
			@Override
			public void invoke(Object object) {
				event.invoke(new GameUpdateEvent());
			}
			@Override
			public void addListener(Object instance, Method method) {
				event.addListener(instance, method);
			}
		},
		ENTITY_UPDATE {
			private EventListenerList event = new EventListenerList();
			@Override
			public void invoke(Object object) {
				event.invoke(new EntityUpdateEvent((Entity)object));
			}
			@Override
			public void addListener(Object instance, Method method) {
				event.addListener(instance, method);
			}
		},
		ENTITY_DIED {
			private EventListenerList event = new EventListenerList();
			@Override
			public void invoke(Object object) {
				event.invoke(new EntityDiedEvent((Entity)object));
			}
			@Override
			public void addListener(Object instance, Method method) {
				event.addListener(instance, method);
			}
		};
		
		public abstract void invoke(Object object);
		public abstract void addListener(Object instance, Method method);
	}
	
	public static void addListener(Class<?> event, Object instance, Method method) {
		if (event.equals(InitializationEvent.class)) {
			Events.INITIALIZATION.addListener(instance, method);
		}
		else if (event.equals(SessionLoadedEvent.class)) {
			Events.SESSION_LOADED.addListener(instance, method);
		}
		else if (event.equals(SessionInitializedEvent.class)) {
			Events.SESSION_INITIALIZED.addListener(instance, method);
		}
		else if (event.equals(GameUpdateEvent.class)) {
			Events.GAME_UPDATE.addListener(instance, method);
		}
		else if (event.equals(EntityUpdateEvent.class)) {
			Events.ENTITY_UPDATE.addListener(instance, method);
		}
		else if (event.equals(EntityDiedEvent.class)) {
			Events.ENTITY_DIED.addListener(instance, method);
		}
	}
	
}
