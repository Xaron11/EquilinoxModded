package com.xaron.equilinoxmodded.framework;

import java.util.HashMap;
import java.util.Map;

import classification.Classifier;

public final class GameRepository {
	
	private GameRepository() {}
	
	public static classification.Classification getClassification(String key) {
		return Classifier.getClassification(key);
	}
	public static classification.Classification getClassification(Classification key) {
		return Classifier.getClassification(key.get());
	}
	
	public enum Classification 
	{
		Animals("a"),
		Fish("af"),
		SmallFish("afs"),
		BigFish("afb"),
		Herbivore("ah"),
		SmallHerbivore("ahs"),
		MediumHerbivore("ahm"),
		LargeHerivore("ahl"),
		Bird("ab"),
		SmallBird("abs"),
		BirdOfPrey("abp"),
		Carnivore("ac"),
		SmallCarnivore("acs"),
		LargeCarnivore("acl"),
		Insect("ai"),
		Reptile("ar"),
		Plants("p"),
		Tree("pt"),
		ForestTree("ptf"),
		GrassTree("ptg"),
		WoodlandTree("ptw"),
		LushTree("ptl"),
		DesertTree("ptd"),
		SnowTree("ptm"),
		SwampTree("pts"),
		JungleTree("ptj"),
		TropicalTree("ptt"),
		Bush("pb"),
		FruityBush("pbf"),
		LeafyBush("pbl"),
		Cactus("pc"),
		SmallPlant("pn"),
		WaterPlant("pnw"),
		Grass("png"),
		RootVegetable("pnv"),
		VegetablePlant("pnp"),
		Fern("pnx"),
		Flower("pnf"),
		Herp("pnh"),
		Mushroom("pnm"),
		NonLiving("e"),
		Rock("er"),
		Stone("ers"),
		LargeRock("erl"),
		Other("eo"),
		Cloud("ec"),
		Fruit("ef"),
		Vegetable("ev"),
		Nut("en"),
		Meat("em"),
		Structure("es");
		
		String key;
		
		Classification(String key) {
			this.key = key;
		}
		
		public String get() {
			return key;
		}
		
		public String get(int id) {
			return key + Integer.toString(id);
		}
	}
	
	@SuppressWarnings("serial")
	protected static Map<String, Integer> blueprintRepository = new HashMap<String, Integer>() {{
	    put("Sheep", 1);
	    put("Oak", 2);
	    put("BerryBush", 3);
	    put("JuniperTree", 4);
	    put("Acer", 5);
	    put("Rocks", 6);
	    put("Heather", 7);
	    put("Chicken", 8);
	    put("Pebbles", 9);
	    put("Fern", 10);
	    put("Wheat", 11);
	    put("Tortoise", 12);
	    put("Kelp", 13);
	    put("Trout", 14);
	    put("Herring", 15);
	    put("Lilly", 16);
	    put("Seaweed", 17);
	    put("Cactus", 18);
	    put("PricklyPear", 19);
	    put("Grass", 20);
	    put("Yucca", 21);
	    
	    put("Pike", 23);
	    put("BirchTree", 25);
	    put("PinkTree", 26);
	    put("PalmTree", 27);
	    put("TallTree", 28);
	    
	    put("CherryTree", 30);
	    put("Mushroom", 31);
	    put("AppleTree", 32);
	    put("Apple", 33);
	    put("JungleRocks", 35);
	    put("JunglePlant", 36);
	    put("VineTree", 37);
	    put("Frog", 38);
	    put("JungleMushroom", 39);
	    put("Coconut", 40);
	    put("Rabbit", 41);
	    put("RedTree", 42);
	    put("BananaTree", 43);
	    put("Banana", 44);
	    put("Carrot", 45);
	    put("UmbrellaTree", 46);
	    put("OrangeTree", 47);
	    put("Orange", 48);
	    put("Squirrel", 49);
	    put("Boar", 50);
	    put("PotatoPlant", 51);
	    put("GuineaPig", 52);
	    put("Potato", 53);
	    put("LargeTree", 54);
	    put("Butterfly", 55);
	    put("Bee", 56);
	    put("Hive", 57);
	    put("SwampTree", 58);
	    put("RedMushroom", 59);
	    put("LongGrass", 60);
	    
	    put("TomatoPlant", 62);
	    put("Toucan", 63);
	    put("Sparrow", 64);
	    put("Duck", 65);
	    put("Eucalyptus", 66);
	    put("SpiralTree", 67);
	    put("Nest", 68);
	    put("SpindleTree", 69);
	    put("Bamboo", 70);
	    put("BlueberryBush", 71);
	    put("Wolf", 72);
	    put("DesertHare", 73);
	    put("Toad", 74);
	    put("Lizard", 75);
	    put("ClownFish", 76);
	    
	    put("Bear", 78);
	    put("Warthog", 79);
	    put("Tulip", 80);
	    put("ForestTree", 81);
	    
	    put("TallFir", 83);
	    put("Fox", 84);
	    put("Camel", 85);
	    
	    
	    
	    put("Beaver", 89);
	    
	    
	    put("Goat", 92);
	    
	    put("MangoTree", 94);
	    
	    
	    
	    put("Deer", 99);
	    put("Twig", 100);
	    put("Bark", 101);
	    put("Den", 102);
	    put("SnapDragon", 103);
	    put("Meat", 104);
	    put("WildMint", 105);
	    put("Sage", 106);
	    put("Oregano", 107);
	    put("Rosemary", 108);
	    put("FlowerTree", 109);
	    put("Willow", 110);
	    put("BigFlower", 111);
	    put("ElmTree", 112);
	    put("BirchTree3", 113);
	    put("Daisy", 114);
	    put("Buttercup", 115);
	    put("Poppy", 116);
	    put("TropicalFlower", 117);
	    put("Bluebell", 118);
	    put("ButtonMushroom", 119);
	    put("SmallCactus", 120);
	    put("GiantCactus", 121);
	    put("DesertTree", 122);
	    put("JungleGrass", 123);
	    put("SmallJungleTree", 124);
	    put("TallJungleTree", 125);
	    put("SpecialMushroom", 126);
	    put("LushFlower", 127);
	    put("FloweryGrass", 128);
	    put("TropicalPlant", 129);
	    put("LeafyPlant", 130);
	    put("PineTree", 131);
	    put("FirTree", 132);
	    put("HollyBush", 133);
	    put("RedMaple", 135);
	    put("SnowRocks", 134);
	    put("TropicalSeaweed", 136);
	    put("NutTree", 137);
	    put("Nut", 138);
	    put("BirdMeat", 139);
	    put("SmallMeat", 140);
	    put("Mango", 141);
	    put("Turnip", 142);
	    put("Bullrush", 143);
	    put("SwampFlower", 144);
	    put("Peacock", 145);
	    put("DeadTree", 146);
	    
	    put("Barley", 148);
	    put("LushGrass", 149);
	    put("PerfectTree", 150);
	    put("Rose", 151);
	    put("Lily", 152);
	    put("SunFlower", 153);
	    put("Pansies", 154);
	    put("FloppyTree", 155);
	    put("NewTree", 156);
	    put("Healbloom", 157);
	    put("Seed", 158);
	    put("WitchWood", 159);
	    put("WitchWoodFruit", 160);
	    put("Dove", 161);
	    put("Stones", 162);
	    put("Boulders", 163);
	    put("Spit", 164);
	    put("Coral", 165);
	    put("Shell", 166);
	    put("Salmon", 167);
	    put("AngelFish", 168);
	    put("NeonFish", 169);
	    put("RoyalGramma", 170);
	    put("Eagle", 171);
	    put("JellyFish", 172);
	    put("MoonBush", 173);
	    put("EagleNest", 174);
	    put("Fly", 175);
	    put("CarnivorePlant", 176);
	    put("Tongue", 177);
	    put("Meerkat", 178);
	    put("Burrow", 179);
	    put("DesertGrass", 180);
	    put("DesertRock", 181);
	    put("Marigolds", 182);
	    put("Dolphin", 183);
	}};
	
	public static int getBlueprintId(String name) {
		if (blueprintRepository.containsKey(name))
			return blueprintRepository.get(name);
		else
			return -1;
	}
	
	@SuppressWarnings("serial")
	protected static Map<String, Integer> taskRepository = new HashMap<String, Integer>() {{
	    put("GrassTask", 1);
	    put("FlowerPower", 2);
	    put("TreeTask", 3);
	    put("MoreGrassTask", 4);
	    put("SheepTask", 5);
	    put("BreedWheatTask", 6);
	    put("GenModTask", 7);
	    put("ChickenTask", 10);
	    put("BoarTask", 11);
	    put("UnderwaterTask", 12);
	    put("FishingTask", 13);
	    put("DiversifyTask", 14);
	    put("AppleDayTask", 15);
	    put("AppleEveryTask", 16);
	    put("CompletionTask", 17);
	    put("BirdTask", 18);
	    put("DuckTask", 19);
	    put("GrassyTask", 20);
	    put("MerryBerryTask", 21);
	    put("DesertTask", 22);
	    put("WoodlandTask", 23);
	    put("CarrotTask", 24);
	    put("GoldCarrotTask", 25);
	    put("ForestFaunaTask", 26);
	    put("MountaineeringTask", 27);
	    put("NutsTask", 28);
	    put("DeerTask", 29);
	    put("TropicalTask", 30);
	    put("CoconutsTask",31);
	    put("TropicalWatersTask", 32);
	    put("BaaTask", 33);
	    put("MarshTask", 34);
	    put("PotatoTask", 35);
	    put("JungleTask", 36);
	    put("MightyJungleTask", 37);
	    put("ButterflyCatchTask", 38);
	    put("TurnipTask", 39);
	    put("BeaverTask", 40);
	    put("ButterflyTask", 41);
	    put("HoneyTask", 42);
	    put("HungeryTurtleTask", 43);
	    put("MushroomTask", 44);
	    put("LushTask", 45);
	    put("PikeTask",46);
	    put("TreeCuttingTask", 47);
	    put("HungryFishTask", 48);
	    put("ButterflyHunterTask", 49);
	    put("BananaFarmerTask", 50);
	    put("HoneyHarvesterTask", 51);
	    put("DiggyHoleTask", 52);
	    put("HuntingTask", 53);
	    put("WolfHuntingTask", 54);
	    put("EarningTask", 55);
	    put("PigPotatoTask", 56);
	    put("CamelTask", 57);
	    put("FishMasteryTask", 58);
	    put("BloomingTask", 59);
	    put("FlyCatchingTask", 60);
	    put("DesertEagleTask", 61);
	    put("HoleInOneTask", 62);
	}};
	
	public static int getTaskId(String name) {
		if (taskRepository.containsKey(name))
			return taskRepository.get(name);
		else
			return -1;
	}
}
