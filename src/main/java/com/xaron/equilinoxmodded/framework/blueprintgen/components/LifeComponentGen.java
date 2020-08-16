package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class LifeComponentGen extends ComponentGen {

	private float averagePop;
	private float averageLife;
	private float[] popFactors;
	private float breedMaturity;
	private float averageBreedTime;
	private int parent = 0;
	private int breedCount = 0;
	private ComponentGen[] requirements;
	
	public LifeComponentGen(float averagePop, float averageLife, float[] popFactors, float breedMaturity, float averageBreedTime, int parent, int breedCount, ComponentGen[] requirements) {
		super("LIFE");
		this.averagePop = averagePop;
		this.averageLife = averageLife;
		this.popFactors = popFactors;
		this.breedMaturity = breedMaturity;
		this.averageBreedTime = averageBreedTime;
		this.parent = parent;
		this.breedCount = breedCount;
		this.requirements = requirements;
	}
	
	public LifeComponentGen(float averagePop, float averageLife, float[] popFactors, float breedMaturity, float averageBreedTime) {
		super("LIFE");
		this.averagePop = averagePop;
		this.averageLife = averageLife;
		this.popFactors = popFactors;
		this.breedMaturity = breedMaturity;
		this.averageBreedTime = averageBreedTime;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("averagePop", averagePop);
		writer.writeLabelFloat("averageLife", averageLife);
		writer.writeLabelFloatArray("popFactors", popFactors);
		writer.writeLabelFloat("breedMaturity", breedMaturity);
		writer.writeLabelFloat("averageBreedTime", averageBreedTime);
		writer.writeLabelInt("parent", parent);
		writer.writeLabelInt("breedCount", breedCount);
		if (requirements != null && requirements.length != 0) {
			writer.writeLabelInt("reqsCount", requirements.length);
			for (int i = 0; i < popFactors.length; i++) {
				requirements[i].writeRequirement(writer);
			}
		}
	}

}
