package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class FlyTrapComponentGen extends ComponentGen {

	private Vector3f startPos;
	
	
	public FlyTrapComponentGen(Vector3f startPos) {
		super("FLYTRAP");
		this.startPos = startPos;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelVector("startPos", startPos);
	}

}
