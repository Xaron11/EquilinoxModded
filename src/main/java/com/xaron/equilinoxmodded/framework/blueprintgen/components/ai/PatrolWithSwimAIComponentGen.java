package com.xaron.equilinoxmodded.framework.blueprintgen.components.ai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import aiComponent.AiProgramType;

public class PatrolWithSwimAIComponentGen extends AIComponentGen {

	private float minIdleTime = 5.0F;
	private float maxIdleTime = 10.0F;
	
	public PatrolWithSwimAIComponentGen(float minIdleTime, float maxIdleTime) {
		super(AiProgramType.PATROL_WITH_SWIM);
		this.minIdleTime = minIdleTime;
		this.maxIdleTime = maxIdleTime;
	}
	
	public PatrolWithSwimAIComponentGen() {
		super(AiProgramType.PATROL_WITH_SWIM);
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("minIdleTime", minIdleTime);
		writer.writeLabelFloat("maxIdleTime", maxIdleTime);
	}

}
