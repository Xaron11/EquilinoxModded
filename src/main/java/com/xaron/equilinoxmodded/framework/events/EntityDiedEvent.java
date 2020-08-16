package com.xaron.equilinoxmodded.framework.events;

import com.xaron.equilinoxmodded.framework.Entity;

public class EntityDiedEvent extends Event {
	public Entity entity;
	
	protected EntityDiedEvent(Entity entity) {
		this.entity = entity;
	}
}
