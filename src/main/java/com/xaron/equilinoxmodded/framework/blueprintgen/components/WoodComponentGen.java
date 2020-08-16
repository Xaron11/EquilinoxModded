package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import toolbox.Colour;

public class WoodComponentGen extends ComponentGen {

	private float cutTime;
	private float barkFactor;
	private Colour colour;
	
	
	public WoodComponentGen(float cutTime, float barkFactor, Colour colour) {
		super("WOOD");
		this.cutTime = cutTime;
		this.barkFactor = barkFactor;
		this.colour = colour;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("cutTime", cutTime);
		writer.writeLabelFloat("barkFactor", barkFactor);
		writer.writeLabelVector("colour", colour.getVector());
	}

}
