package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class BuildComponentGen extends ComponentGen {

	private int stageCount;
	private int maxBuildPoints;
	private Integer fullyBuiltPoints;
	
	
	public BuildComponentGen(int stageCount, int maxBuildPoints, int fullyBuiltPoints) {
		super("BUILD");
		this.stageCount = stageCount;
		this.maxBuildPoints = maxBuildPoints;
		this.fullyBuiltPoints = fullyBuiltPoints;
	}
	
	public BuildComponentGen(int stageCount, int maxBuildPoints) {
		super("BUILD");
		this.stageCount = stageCount;
		this.maxBuildPoints = maxBuildPoints;
		this.fullyBuiltPoints = null;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeInt(stageCount);
		writer.writeInt(maxBuildPoints);
		if (fullyBuiltPoints != null)
			writer.writeLabelInt("fullyBuiltPoints", fullyBuiltPoints);
	}

}
