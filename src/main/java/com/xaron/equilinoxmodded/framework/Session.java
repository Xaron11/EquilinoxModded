package com.xaron.equilinoxmodded.framework;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.util.vector.Vector3f;

import classification.Classification;
import inventory.Inventory;
import saves.SaveSlot;
import session.GameMode;
import terrains.TerrainVertex;
import time.Calendar;
import world.UnplaceableReason;
import world.World;

public class Session {
	private session.Session session;
	
	public Session(session.Session session) {
		this.session = session;
	}
	
	public Inventory getInventory() {
		return session.getInventory();
	}
	
	public GameMode getMode() {
		return session.getMode();
	}
	
	public SaveSlot getSave() {
		return session.getSave();
	}
	
	public int getDpCount() {
		return session.getStats().getDpCount();
	}
	
	public int getDpPerMinute() {
		return session.getStats().getDpPerMinute();
	}
	
	public void increaseDp(int increase) {
		session.getStats().increaseDp(increase);
	}
	
	public void setDpPerMinute(int amount) {
		session.getStats().setDpPerMinute(amount);
	}
	
	public Calendar getCalendar() {
		return session.getStats().getCalendar();
	}
	
	public float getWorldAltitude(float height) {
		return session.getWorld().getAltitude(height);
	}
	
	public float getWorldAltitude(float x, float z) {
		return session.getWorld().getAltitude(x, z);
	}
	
	public int getWorldSeed() {
		return session.getWorld().getConfigs().getSeed();
	}
	
	public float getWorldMaxHeight() {
		return session.getWorld().getConfigs().getMaxHeight();
	}
	
	public float getWorldSmoothness() {
		return session.getWorld().getConfigs().getSmoothness();
	}
	
	public int getWorldEntityCount() {
		return session.getWorld().getEntityGrid().getEntityCount();
	}
	
	public Map<Integer, Entity> getWorldEntities() {
		Map<Integer, instances.Entity> entities = session.getWorld().getEntityGrid().getWorldEntities();
		Map<Integer, Entity> newEntities = new HashMap<Integer, Entity>();
		for (int i : entities.keySet()) {
			newEntities.put(i, new Entity(entities.get(i)));
		}
		return newEntities;
	}
	
	public float getWorldEntities(float x, float z) {
		return session.getWorld().getHeightOfTerrain(x, z);
	}
	
	public int getWorldPopulation(Classification classification, int range, float x, float z) {
		return session.getWorld().getPopulation(classification, range, x, z);
	}
	
	public float getWorldSize() {
		return session.getWorld().getSize();
	}
	
	public TerrainVertex getWorldTerrainVertex(float x, float z) {
		return session.getWorld().getTerrainVertex(x, z);
	}
	
	public float getWorldWaterHeight() {
		return session.getWorld().getWaterHeight();
	}
	
	public UnplaceableReason isAcceptableLocation(blueprints.Blueprint blueprint, float x, float z) {
		return session.getWorld().isAcceptableLocation(blueprint, x, z);
	}
	
	public boolean isOnWorld(Vector3f point) {
		return session.getWorld().isOnWorld(point);
	}
	
	public static void clampPositionToInsideWorld(Vector3f pos) {
		World.clampPositionToInsideWorld(pos);
	}
	
	public static void clampPositionToWorld(Vector3f pos) {
		World.clampPositionToWorld(pos);
	}
}
