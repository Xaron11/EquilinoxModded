package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class BuilderComponentGen extends ComponentGen {

	private int buildModel;
	private int buildSpeed;
	private boolean needsPerch;
	private float averageBuildTime;
	private float buildAgeFactor;
	private float earlyBuildTime = 0.0F;
	
	
	public BuilderComponentGen(int buildModel, int buildSpeed, boolean needsPerch, float averageBuildTime, float buildAgeFactor, float earlyBuildTime) {
		super("BUILDER");
		this.buildModel = buildModel;
		this.buildSpeed = buildSpeed;
		this.needsPerch = needsPerch;
		this.averageBuildTime = averageBuildTime;
		this.buildAgeFactor = buildAgeFactor;
		this.earlyBuildTime = earlyBuildTime;
	}
	
	public BuilderComponentGen(int buildModel, int buildSpeed, boolean needsPerch, float averageBuildTime, float buildAgeFactor) {
		super("BUILDER");
		this.buildModel = buildModel;
		this.buildSpeed = buildSpeed;
		this.needsPerch = needsPerch;
		this.averageBuildTime = averageBuildTime;
		this.buildAgeFactor = buildAgeFactor;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("buildModel", buildModel);
		writer.writeLabelInt("buildSpeed", buildSpeed);
		writer.writeLabelBool("needsPerch", needsPerch);
		writer.writeLabelFloat("averageBuildTime", averageBuildTime);
		writer.writeLabelFloat("buildAgeFactor", buildAgeFactor);
		writer.writeLabelFloat("earlyBuildTime", earlyBuildTime);
	}

}
