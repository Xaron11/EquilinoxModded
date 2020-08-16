package com.xaron.equilinoxmodded.framework.blueprintgen.components.deathai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class FloaterDeathGen implements DeathAIGen {

	private float deadRot;
	
	public FloaterDeathGen(float deadRot) {
		this.deadRot = deadRot;
	}
	
	public void write(CsvWriter writer) throws IOException {
		writer.writeLabelFloat("deadRot", deadRot);
	}
}
