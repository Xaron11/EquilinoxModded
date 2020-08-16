package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class FruiterComponentGen extends ComponentGen {

	private int fruitModel;
	private int stageCount;
	private float fruitTime = 5.0F;
	
	public FruiterComponentGen(int fruitModel, int stageCount) {
		super("FRUITER");
		this.fruitModel = fruitModel;
		this.stageCount = stageCount;
	}
	
	public FruiterComponentGen(int fruitModel, int stageCount, float fruitTime) {
		super("FRUITER");
		this.fruitModel = fruitModel;
		this.stageCount = stageCount;
		this.fruitTime = fruitTime;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("fruitModel", fruitModel);
		writer.writeLabelInt("stageCount", stageCount);
		writer.writeLabelFloat("fruitTime", fruitTime);
	}

}
