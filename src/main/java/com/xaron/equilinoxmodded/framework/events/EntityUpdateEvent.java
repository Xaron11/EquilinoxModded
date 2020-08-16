package com.xaron.equilinoxmodded.framework.events;

import com.xaron.equilinoxmodded.framework.Entity;

public class EntityUpdateEvent extends Event {
	public Entity entity;
	
	protected EntityUpdateEvent(Entity entity) {
		this.entity = entity;
	}
}
