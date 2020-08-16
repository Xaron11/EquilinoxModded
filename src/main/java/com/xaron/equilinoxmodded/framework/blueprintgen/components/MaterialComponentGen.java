package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import materials.PresetColour;
import toolbox.Colour;


public class MaterialComponentGen extends ComponentGen {

	private boolean hasSecondNatural;
	private MaterialColour[] colours;
	
	public class MaterialColour {
		
		private PresetColour presetColour;
		private Colour customColour;
		private int price;
		
		public MaterialColour(PresetColour presetColour, int price) {
			this.presetColour = presetColour;
			this.price = price;
		}
		
		public MaterialColour(Colour customColour, int price) {
			this.presetColour = PresetColour.CUSTOM;
			this.customColour = customColour;
			this.price = price;
		}
	}
	
	public MaterialComponentGen(boolean hasSecondNatural, MaterialColour[] colours) {
		super("EQUIP");
		this.hasSecondNatural = hasSecondNatural;
		this.colours = colours;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelBool("hasSecondNatural", hasSecondNatural);
		writer.writeLabelInt("colourCount", colours.length);
		for (int i = 0; i < colours.length; i++) {
			writer.writeString(colours[i].presetColour.name());
			if (colours[i].presetColour == PresetColour.CUSTOM) {
				writer.writeVector(colours[i].customColour.getVector());
			}
			writer.writeInt(colours[i].price);
		}
		
	}

}
