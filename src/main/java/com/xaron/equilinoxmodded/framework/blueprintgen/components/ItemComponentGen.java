package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class ItemComponentGen extends ComponentGen {

	private float decayTime;
	
	public ItemComponentGen(float decayTime) {
		super("ITEM");
		this.decayTime = decayTime;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("decayTime", decayTime);
	}

}
