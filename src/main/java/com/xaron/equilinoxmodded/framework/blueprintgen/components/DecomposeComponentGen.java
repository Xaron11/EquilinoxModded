package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class DecomposeComponentGen extends ComponentGen {

	private float timePerLoss;
	
	
	public DecomposeComponentGen(float timePerLoss) {
		super("DECOMPOSE");
		this.timePerLoss = timePerLoss;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("timePerLoss", timePerLoss);
	}

}
