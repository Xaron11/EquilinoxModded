package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;


import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.GameRepository.Classification;


public class FleeComponentGen extends ComponentGen {

	private FleeType type;
	private float safeRange;
	private boolean canBeOnLand;
	private boolean canSwim;
	Classification hidingSpot = null;
	
	public enum FleeType {
		TURTLE,
		MEERKAT
	}
	
	public FleeComponentGen(FleeType type, float safeRange, boolean canBeOnLand, boolean canSwim) {
		super("FLEE");
		this.type = type;
		this.safeRange = safeRange;
		this.canBeOnLand = canBeOnLand;
		this.canSwim = canSwim;
	}
	
	public FleeComponentGen(FleeType type, float safeRange, boolean canBeOnLand, boolean canSwim, Classification hidingSpot) {
		super("FLEE");
		this.type = type;
		this.safeRange = safeRange;
		this.canBeOnLand = canBeOnLand;
		this.canSwim = canSwim;
		this.hidingSpot = hidingSpot;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeString(type.name());
		writer.writeFloat(safeRange);
		writer.writeLabelBool("canBeOnLand", canBeOnLand);
		writer.writeLabelBool("canSwim", canSwim);
		if (hidingSpot != null)
			writer.writeLabelString("hidingSpot", hidingSpot.get());
	}

}
