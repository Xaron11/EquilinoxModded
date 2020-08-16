package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class BeeMovementComponentGen extends MovementComponentGen {

	private float cruiseHeight;
	
	public BeeMovementComponentGen(float cruiseHeight) {
		super(11);
		this.cruiseHeight = cruiseHeight;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("cruiseHeight", cruiseHeight);
	}
}
