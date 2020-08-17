package com.xaron.equilinoxmodded.framework;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.util.vector.Vector3f;

import com.xaron.equilinoxmodded.framework.GameRepository.Classification;

import terrains.TerrainVertex;
import world.UnplaceableReason;

public class World {

	private world.World world;
	
	protected World(world.World world) {
		this.world = world;
	}
	
	public float getAltitude(float height) {
		return world.getAltitude(height);
	}
	
	public float getAltitude(float x, float z) {
		return world.getAltitude(x, z);
	}
	
	public int getSeed() {
		return world.getConfigs().getSeed();
	}
	
	public float getMaxHeight() {
		return world.getConfigs().getMaxHeight();
	}
	
	public float getSmoothness() {
		return world.getConfigs().getSmoothness();
	}
	
	public int getEntityCount() {
		return world.getEntityGrid().getEntityCount();
	}
	
	public Map<Integer, Entity> getEntities() {
		Map<Integer, instances.Entity> entities = world.getEntityGrid().getWorldEntities();
		Map<Integer, Entity> newEntities = new HashMap<Integer, Entity>();
		for (int i : entities.keySet()) {
			newEntities.put(i, new Entity(entities.get(i)));
		}
		return newEntities;
	}
	
	public float getHeightOfTerrain(float x, float z) {
		return world.getHeightOfTerrain(x, z);
	}
	
	public int getPopulation(Classification classification, int range, float x, float z) {
		return world.getPopulation(GameRepository.getClassification(classification), range, x, z);
	}
	
	public float getSize() {
		return world.getSize();
	}
	
	public TerrainVertex getTerrainVertex(float x, float z) {
		return world.getTerrainVertex(x, z);
	}
	
	public float getWaterHeight() {
		return world.getWaterHeight();
	}
	
	public UnplaceableReason isAcceptableLocation(blueprints.Blueprint blueprint, float x, float z) {
		return world.isAcceptableLocation(blueprint, x, z);
	}
	
	public boolean isOnWorld(Vector3f point) {
		return world.isOnWorld(point);
	}
}
