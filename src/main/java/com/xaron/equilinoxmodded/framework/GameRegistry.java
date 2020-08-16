package com.xaron.equilinoxmodded.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;


import resourceManagement.BlueprintRepository;

public final class GameRegistry {
	
	private GameRegistry() {}
	
	public enum Shop
	{
		Plant,
		Animal
	}
	
	private static Map<Integer, Supplier<Blueprint>> registeredBlueprints = new HashMap<Integer, Supplier<Blueprint>>();
	private static Map<Integer, Supplier<Task>> registeredTasks = new HashMap<Integer, Supplier<Task>>();
	private static List<String> registeredPlantShopItems = new ArrayList<String>();
	private static List<String> registeredAnimalShopItems = new ArrayList<String>();
	
	private static Map<Integer, String> gameTexts = new HashMap<Integer, String>();
	
	public static GameText addGameText(String text) {
		int id = nextGameTextId();
		gameTexts.put(id, text);
		return new GameText(id, text);
	}

	public static void registerBlueprint(String registryName, Supplier<Blueprint> blueprint) {
		GameRepository.blueprintRepository.put(registryName, nextBlueprintId());
		registeredBlueprints.put(Integer.valueOf(nextBlueprintId()), blueprint);
	}
	
	public static void registerBlueprint(int id, String registryName, Supplier<Blueprint> blueprint) {
		GameRepository.blueprintRepository.put(registryName, id);
		registeredBlueprints.put(Integer.valueOf(id), blueprint);
	}
	
	public static void registerTask(String registryName, Supplier<Task> task) {
		GameRepository.taskRepository.put(registryName, nextTaskId());
		registeredTasks.put(Integer.valueOf(nextTaskId()), task);
	}
	
	public static void registerShopItem(Shop shop, String blueprintName) {
		if (shop == Shop.Plant)
			registeredPlantShopItems.add(blueprintName);
		else if (shop == Shop.Animal)
			registeredAnimalShopItems.add(blueprintName);
	}
	
	private static int nextBlueprintId() {
		return 184 + registeredBlueprints.keySet().size();
	}
	
	private static int nextTaskId() {
		return 63 + registeredTasks.size();
	}
	
	private static int nextGameTextId() {
		return 1189 + gameTexts.size();
	}
	
	public static Map<Integer, List<String>> getGameTexts() {
		List<Integer> keys = new ArrayList<Integer>(gameTexts.keySet());
		List<List<String>> values = gameTexts.values().stream().map(x -> Arrays.asList(new String[] {x})).collect(Collectors.toList());
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for (int i = 0; i < keys.size(); i++) {
			map.put(keys.get(i), values.get(i));
		}
		return map;
	}
	
	public static Map<Integer, blueprints.Blueprint> getBlueprints() {
		Map<Integer, blueprints.Blueprint> blueprints = new HashMap<Integer, blueprints.Blueprint>();
		
		for (Integer i : registeredBlueprints.keySet()) {
			blueprints.put(i, registeredBlueprints.get(i).get().getBlueprint(i));
		}
		
		return blueprints;
	}
	
	public static List<tasks.Task> getTasks() {
		List<tasks.Task> tasks = new ArrayList<tasks.Task>();
		for (Integer i : registeredTasks.keySet()) {
			tasks.add(registeredTasks.get(i).get().getTask(i));
		}
		return tasks;
	}
	
	public static List<blueprints.Blueprint> getPlantShopItems() {
		List<blueprints.Blueprint> blueprints = new ArrayList<blueprints.Blueprint>();
		for (String n : registeredPlantShopItems) {
			blueprints.add(BlueprintRepository.getBlueprint(GameRepository.getBlueprintId(n)));
		}
		return blueprints;
	}
	public static List<blueprints.Blueprint> getAnimalShopItems() {
		List<blueprints.Blueprint> blueprints = new ArrayList<blueprints.Blueprint>();
		for (String n : registeredAnimalShopItems) {
			blueprints.add(BlueprintRepository.getBlueprint(GameRepository.getBlueprintId(n)));
		}
		return blueprints;
	}

}
