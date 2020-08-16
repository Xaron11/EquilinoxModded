package com.xaron.equilinoxmodded.framework.events;

import com.xaron.equilinoxmodded.framework.Session;

public class SessionInitializedEvent extends Event {
	public Session session;
	
	protected SessionInitializedEvent(Session session) {
		this.session = session;
	}
}
