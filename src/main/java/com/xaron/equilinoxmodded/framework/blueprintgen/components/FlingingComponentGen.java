package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class FlingingComponentGen extends ComponentGen {

	private float min;
	private float max;
	
	public FlingingComponentGen(float min, float max) {
		super("FLINGING");
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("min", min);
		writer.writeLabelFloat("max", max);
	}

}
