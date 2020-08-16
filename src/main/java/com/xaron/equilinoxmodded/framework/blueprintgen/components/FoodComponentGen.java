package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.blueprintgen.components.deathai.DeathAIGen;

import food.FoodSectionType;

public class FoodComponentGen extends ComponentGen {

	public class FoodSection {
		
		private int name;
	    private int foodPoints;
	    private FoodSectionType type;
	    private int portions = 0;
	    private DeathAIGen deathAi;
		
		public FoodSection(int name, int foodPoints, FoodSectionType type, DeathAIGen deathAi) {
			this.name = name;
			this.foodPoints = foodPoints;
			this.type = type;
			this.deathAi = deathAi;
		}
		
		public FoodSection(int name, int foodPoints, int portions) {
			this.name = name;
			this.foodPoints = foodPoints;
			this.type = FoodSectionType.TO_SHARE;
			this.portions = portions;
		}
	}
	
	private FoodSection[] foodSections;
	
	public FoodComponentGen(FoodSection[] foodSections) {
		super("FOOD");
		this.foodSections = foodSections;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeInt(foodSections.length);
		
		for (int i = 0; i < foodSections.length; i++) {
			writer.writeInt(foodSections[i].name);
			writer.writeInt(foodSections[i].foodPoints);
			writer.writeString(foodSections[i].type.name());
			if (foodSections[i].type == FoodSectionType.TO_SHARE)
				writer.writeLabelInt("portions", foodSections[i].portions);
			else if (foodSections[i].type == FoodSectionType.WHOLE)
				foodSections[i].deathAi.write(writer);
			else if (foodSections[i].type == FoodSectionType.ROOT_VEG)
				foodSections[i].deathAi.write(writer);
		}
	}

}
