package com.xaron.equilinoxmodded.framework.events;

import com.xaron.equilinoxmodded.framework.Session;

public class SessionLoadedEvent extends Event {
	public Session session;
	
	protected SessionLoadedEvent(Session session) {
		this.session = session;
	}
}
