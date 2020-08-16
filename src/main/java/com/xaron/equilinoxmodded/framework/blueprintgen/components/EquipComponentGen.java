package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class EquipComponentGen extends ComponentGen {

	private Vector3f[] positions;
	
	public EquipComponentGen(Vector3f[] positions) {
		super("EQUIP");
		this.positions = positions;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		for (int i = 0; i < positions.length; i++) {
			writer.writeLabelVector("pos", positions[i]);
		}
	}

}
