package com.xaron.equilinoxmodded.framework.blueprintgen.components.deathai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class FallDeathGen implements DeathAIGen {

	private float fallTime;
	private float totalTime;
	private float fallenAngle;
	
	public FallDeathGen(float fallTime, float totalTime, float fallenAngle) {
		this.fallTime = fallTime;
		this.totalTime = totalTime;
		this.fallenAngle = fallenAngle;
	}
	
	public void write(CsvWriter writer) throws IOException {
		writer.writeLabelFloat("fallTime", fallTime);
		writer.writeLabelFloat("totalTime", totalTime);
		writer.writeLabelFloat("fallenAngle", fallenAngle);
	}
}
