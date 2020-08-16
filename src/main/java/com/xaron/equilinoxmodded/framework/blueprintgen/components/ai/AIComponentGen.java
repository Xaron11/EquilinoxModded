package com.xaron.equilinoxmodded.framework.blueprintgen.components.ai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.blueprintgen.components.ComponentGen;

import aiComponent.AiProgramType;

public class AIComponentGen extends ComponentGen {

	private AiProgramType type;
	
	
	public AIComponentGen(AiProgramType type) {
		super("AI");
		this.type = type;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeString(type.name());
	}
}
