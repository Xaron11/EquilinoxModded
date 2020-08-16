package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class DecayComponentGen extends ComponentGen {

	private float lifeTime;
	
	public DecayComponentGen(float lifeTime) {
		super("DECAY");
		this.lifeTime = lifeTime;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeFloat(lifeTime);
	}

}
