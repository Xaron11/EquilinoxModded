package com.xaron.equilinoxmodded.framework.blueprintgen.components.ai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import aiComponent.AiProgramType;

public class BirdAIComponentGen extends AIComponentGen {

	private float circleRot = 50.0F;
	private float circleMinTime = 2.0F;
	
	public BirdAIComponentGen(float circleRot, float circleMinTime) {
		super(AiProgramType.BIRD);
		this.circleRot = circleRot;
		this.circleMinTime = circleMinTime;
	}
	
	public BirdAIComponentGen() {
		super(AiProgramType.BIRD);
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("circleRot", circleRot);
		writer.writeLabelFloat("circleTime", circleMinTime);
	}

}
