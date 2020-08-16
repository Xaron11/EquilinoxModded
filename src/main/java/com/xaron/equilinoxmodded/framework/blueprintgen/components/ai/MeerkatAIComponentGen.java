package com.xaron.equilinoxmodded.framework.blueprintgen.components.ai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import aiComponent.AiProgramType;

public class MeerkatAIComponentGen extends AIComponentGen {

	private float minIdleTime = 7.0F;
	private float maxIdleTime = 15.0F;
	
	public MeerkatAIComponentGen(float minIdleTime, float maxIdleTime) {
		super(AiProgramType.MEERKAT);
		this.minIdleTime = minIdleTime;
		this.maxIdleTime = maxIdleTime;
	}
	
	public MeerkatAIComponentGen() {
		super(AiProgramType.MEERKAT);
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("minIdleTime", minIdleTime);
		writer.writeLabelFloat("maxIdleTime", maxIdleTime);
	}

}
