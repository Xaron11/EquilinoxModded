package com.xaron.equilinoxmodded.framework.blueprintgen.components.ai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import aiComponent.AiProgramType;

public class PatrolAIComponentGen extends AIComponentGen {

	private float minIdleTime = 5.0F;
	private float maxIdleTime = 10.0F;
	
	public PatrolAIComponentGen(float minIdleTime, float maxIdleTime) {
		super(AiProgramType.PATROL);
		this.minIdleTime = minIdleTime;
		this.maxIdleTime = maxIdleTime;
	}
	
	public PatrolAIComponentGen() {
		super(AiProgramType.PATROL);
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("minIdleTime", minIdleTime);
		writer.writeLabelFloat("maxIdleTime", maxIdleTime);
	}

}
