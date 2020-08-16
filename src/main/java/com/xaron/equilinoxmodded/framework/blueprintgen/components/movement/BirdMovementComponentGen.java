package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class BirdMovementComponentGen extends MovementComponentGen {

	private float glideDown = -0.6F;
	
	public BirdMovementComponentGen(float glideDown) {
		super(12);
		this.glideDown = glideDown;
	}
	
	public BirdMovementComponentGen() {
		super(12);
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("glideDown", glideDown);
	}
}
