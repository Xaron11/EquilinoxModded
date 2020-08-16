package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class DropComponentGen extends ComponentGen {

	private int id;
	
	public DropComponentGen(int id) {
		super("EQUIP");
		this.id = id;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("id", id);
	}

}
