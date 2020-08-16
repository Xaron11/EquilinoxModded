package com.xaron.equilinoxmodded.framework.blueprintgen.components.deathai;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class SpawnDeathGen implements DeathAIGen {

	private int entity;
	private int minCount;
  	private int maxCount;
  	private boolean onlyFullGrown;
	
	public SpawnDeathGen(int entity, int minCount, int maxCount, boolean onlyFullGrown) {
		this.entity = entity;
		this.minCount = minCount;
		this.maxCount = maxCount;
		this.onlyFullGrown = onlyFullGrown;
	}
	
	public void write(CsvWriter writer) throws IOException {
		writer.writeInt(entity);
		writer.writeInt(minCount);
		writer.writeInt(maxCount);
		writer.writeBool(onlyFullGrown);
	}
}
