package com.xaron.equilinoxmodded.framework;

import utils.MyFile;

public class Blueprint {
	
	private String file = null;
	float[] modelData;
	
	public Blueprint(String file)
	{
		this.file = file;
	}
	
	public Blueprint(float[] modelData)
	{
		this.modelData = modelData;
	}
	
	protected blueprints.Blueprint getBlueprint(int id) {
		if (file == null) {
			return blueprints.Blueprint.create(id, modelData);
		}
		else {
			return blueprints.Blueprint.load(id, new MyFile("res", "entities", file + ".txt"), false);
		}
	}
}
