package com.xaron.equilinoxmodded.framework;

import java.util.List;

import tasks.Reward;
import tasks.TaskRequirement;

public abstract class Task {

	private String name;
	private String desc;
	
	public Task(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	protected abstract List<TaskRequirement> getRequirements();
	
	protected abstract List<Reward> getRewards();
	
	protected tasks.Task getTask(int id) {
		return new tasks.Task(id, name, desc, getRequirements(), getRewards());
	}
}
