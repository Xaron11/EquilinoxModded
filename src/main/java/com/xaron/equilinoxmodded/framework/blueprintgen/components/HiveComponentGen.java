package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;


import com.xaron.equilinoxmodded.framework.CsvWriter;


public class HiveComponentGen extends ComponentGen {

	private int maxHoney;
	private int startStage;
	private int stageCount;
	
	public HiveComponentGen(int maxHoney, int startStage, int stageCount) {
		super("HIVE");
		this.maxHoney = maxHoney;
		this.startStage = startStage;
		this.stageCount = stageCount;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeInt(maxHoney);
		writer.writeInt(startStage);
		writer.writeInt(stageCount);
	}

}
