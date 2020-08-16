package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.blueprintgen.components.ComponentGen;


abstract class MovementComponentGen extends ComponentGen {

	private int typeId;
	
	public MovementComponentGen(int typeId) {
		super("MOVEMENT");
		this.typeId = typeId;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeInt(typeId);
	}
}
