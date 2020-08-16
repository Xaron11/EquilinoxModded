package com.xaron.equilinoxmodded.framework.blueprintgen.components.deathai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class FadeDeathGen implements DeathAIGen {

	private float fadeTime;
	
	public FadeDeathGen(float fadeTime) {
		this.fadeTime = fadeTime;
	}
	
	public void write(CsvWriter writer) throws IOException {
		writer.writeFloat(fadeTime);
	}
}
