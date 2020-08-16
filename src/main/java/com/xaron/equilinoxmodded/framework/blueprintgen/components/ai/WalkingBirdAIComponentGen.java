package com.xaron.equilinoxmodded.framework.blueprintgen.components.ai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import aiComponent.AiProgramType;

public class WalkingBirdAIComponentGen extends AIComponentGen {

	private float minIdleTime;
	private float maxIdleTime;
  	private boolean stayOnLand;
	
	public WalkingBirdAIComponentGen(float minIdleTime, float maxIdleTime, boolean stayOnLand) {
		super(AiProgramType.WALKING_BIRD);
		this.minIdleTime = minIdleTime;
		this.maxIdleTime = maxIdleTime;
		this.stayOnLand = stayOnLand;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("minIdleTime", minIdleTime);
		writer.writeLabelFloat("maxIdleTime", maxIdleTime);
		writer.writeLabelBool("maxIdleTime", stayOnLand);
	}

}
