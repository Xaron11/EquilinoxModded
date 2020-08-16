package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class InformationComponentGen extends ComponentGen {

	private int nameId;
	private int descId;
	private int price;
	private int dpPerMin;
	private int range;
	private String placeSound;
	
	
	public InformationComponentGen(int nameId, int descId, int price, int dpPerMin, int range, String placeSound) {
		super("INFO");
		this.nameId = nameId;
		this.descId = descId;
		this.price = price;
		this.dpPerMin = dpPerMin;
		this.range = range;
		this.placeSound = placeSound;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("NameId", nameId);
		writer.writeLabelInt("DescId", descId);
		writer.writeLabelInt("price", price);
		writer.writeLabelInt("dpPerMin", dpPerMin);
		writer.writeLabelInt("range", range);
		writer.writeLabelString("placeSound", placeSound);
	}

}
