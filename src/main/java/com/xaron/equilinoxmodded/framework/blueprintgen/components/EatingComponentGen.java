package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.GameRepository.Classification;

import food.FoodSectionType;

public class EatingComponentGen extends ComponentGen {

	private int maxHungerPoints;
	private float hungerPerHour;
	private float eatingRadius;
	private DietOption[] dietOptions;
	
	private boolean runs = false;
	private EatAI eatAi = EatAI.Standard;
	private boolean eggStage = false;
	
	public enum EatAnimation {
		Simple,
		Throwing,
		Digging,
		Diving,
		Instant
	}
	
	public enum EatAI {
		Standard,
		Fish,
		Bird
	}
	
	public class DietOption {
		private Classification classification;
		private FoodSectionType foodSectionType;
		private EatAnimation eatAnimation;
		
		public DietOption(Classification classification, FoodSectionType foodSectionType, EatAnimation eatAnimation) {
			this.classification = classification;
			this.foodSectionType = foodSectionType;
			this.eatAnimation = eatAnimation;
		}
	}
	
	public EatingComponentGen(int maxHungerPoints, float hungerPerHour, float eatingRadius, DietOption[] dietOptions) {
		super("EATING");
		this.maxHungerPoints = maxHungerPoints;
		this.hungerPerHour = hungerPerHour;
		this.eatingRadius = eatingRadius;
		this.dietOptions = dietOptions;
	}
	
	public EatingComponentGen(int maxHungerPoints, float hungerPerHour, float eatingRadius, DietOption[] dietOptions, boolean runs, EatAI eatAi) {
		super("EATING");
		this.maxHungerPoints = maxHungerPoints;
		this.hungerPerHour = hungerPerHour;
		this.eatingRadius = eatingRadius;
		this.dietOptions = dietOptions;
		this.runs = runs;
		this.eatAi = eatAi;
	}
	
	public EatingComponentGen(int maxHungerPoints, float hungerPerHour, float eatingRadius, DietOption[] dietOptions, boolean runs, EatAI eatAi, boolean eggStage) {
		super("EATING");
		this.maxHungerPoints = maxHungerPoints;
		this.hungerPerHour = hungerPerHour;
		this.eatingRadius = eatingRadius;
		this.dietOptions = dietOptions;
		this.runs = runs;
		this.eatAi = eatAi;
		this.eggStage = eggStage;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("maxHungerPoints", maxHungerPoints);
		writer.writeLabelFloat("hungerPerHour", hungerPerHour);
		writer.writeLabelFloat("eatingRadius", eatingRadius);
		
		Map<EatAnimation, Integer> animIds = new HashMap<EatAnimation, Integer>();
		for (int i = 0; i < dietOptions.length; i++) {
			if (!animIds.containsKey(dietOptions[i].eatAnimation)) {
				animIds.put(dietOptions[i].eatAnimation, i);
			}
		}
		writer.writeLabelInt("EatingAnims", animIds.size());
		for (EatAnimation eatAnim : animIds.keySet()) {
			writer.writeInt(eatAnim.ordinal());
		}
		
		writer.writeLabelInt("DietOptionCount", dietOptions.length);
		for (int i = 0; i < dietOptions.length; i++) {
			writer.writeString(dietOptions[i].classification.get());
			writer.writeString(dietOptions[i].foodSectionType.name());
			writer.writeInt(animIds.get(dietOptions[i].eatAnimation));
		}
		
		writer.writeLabelBool("runs", runs);
		writer.writeLabelInt("eatAi", eatAi.ordinal());
		writer.writeLabelBool("eggStage", eggStage);
	}

}
