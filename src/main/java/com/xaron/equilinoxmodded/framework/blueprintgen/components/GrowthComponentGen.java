package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class GrowthComponentGen extends ComponentGen {

	private boolean dynamic;
	private float averageGrowthTime;
	private int modelStages;
	private int subStages;
	
	
	public GrowthComponentGen(boolean dynamic, float averageGrowthTime, int modelStages, int subStages) {
		super("GROWTH");
		this.dynamic = dynamic;
		this.averageGrowthTime = averageGrowthTime;
		this.modelStages = modelStages;
		this.subStages = subStages;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelBool("dynamic", dynamic);
		writer.writeLabelFloat("averageGrowthTime", averageGrowthTime);
		writer.writeLabelInt("modelStages", modelStages);
		writer.writeLabelInt("subStages", subStages);
	}

}
