package com.xaron.equilinoxmodded.framework;

import java.util.Collection;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import audio.Sound;
import gameManaging.AvailableSpeciesList;
import gameManaging.GameState;
import mainGuis.EquilinoxGuis;
import session.GameMode;
import shops.ShopItem;
import textures.Texture;

public final class GameManager {
	
	private GameManager() {}
	
	public static void pause() {
		gameManaging.GameManager.gameSpeed.pause();
	}
	
	public static void normalSpeed() {
		gameManaging.GameManager.gameSpeed.normalSpeed();
	}
	
	public static void fastSpeed() {
		gameManaging.GameManager.gameSpeed.fastSpeed();
	}
	
	public static float getGameSpeed() {
		return gameManaging.GameManager.gameSpeed.getGameSpeed();
	}
	
	public static void clearEntityPicker() {
		gameManaging.GameManager.entityPicker.clear();
	}
	
	public static void setEntityPickerDeleteMode(float range) {
		gameManaging.GameManager.entityPicker.setDeleteMode(range);
	}
	
	public static void turnOffEntityPickerDeleteMode(float range) {
		gameManaging.GameManager.entityPicker.turnOffDeleteMode();
	}
	
	public static void grabEntity(Entity entity) {
		gameManaging.GameManager.entityPicker.grab(entity.entity);
	}
	
	public static void deselectEntityPicker() {
		gameManaging.GameManager.entityPicker.deselect();
	}
	
	public static GameState getGameState() {
		return gameManaging.GameManager.gameState.getState();
	}
	
	public static Session getSession() {
		return new Session(gameManaging.GameManager.sessionManager.getSession());
	}
	
	public static GameMode getGameMode() {
		return gameManaging.GameManager.getGameMode();
	}
	
	public static float getGameTime() {
		return gameManaging.GameManager.getGameTime();
	}
	
	public static AvailableSpeciesList getUnlockList() {
		return gameManaging.GameManager.getUnlockList();
	}
	
	public static ShopItem getShopItem(int id) {
		return gameManaging.GameManager.getShops().getItem(id);
	}
	
	public static void unlockAllShopItems() {
		gameManaging.GameManager.getShops().unlockAll();
	}
	
	public static void unlockShopItem(int id) {
		gameManaging.GameManager.getShops().unlockItem(id);
	}
	
	public static void unlockNecessaryShopItems(Collection<Integer> unlockedItems) {
		gameManaging.GameManager.getShops().unlockNecessaryItems(unlockedItems);
	}
	
	public static void unlockShopItems(Collection<Integer> unlockedItems) {
		gameManaging.GameManager.getShops().unlockItems(unlockedItems);
	}
	
	public static List<ShopItem> getAnimalShopStock() {
		return gameManaging.GameManager.getShops().getAnimalShop().getShopStock();
	}
	
	public static List<ShopItem> getPlantShopStock() {
		return gameManaging.GameManager.getShops().getPlantShop().getShopStock();
	}
	
	public static int getAnimalShopNumberUnlocked() {
		return gameManaging.GameManager.getShops().getAnimalShop().getNumberUnlocked();
	}
	
	public static int getPlantShopNumberUnlocked() {
		return gameManaging.GameManager.getShops().getPlantShop().getNumberUnlocked();
	}
	
	public static void unlockAllAnimalShopItems() {
		gameManaging.GameManager.getShops().getAnimalShop().unlockAll();
	}
	
	public static void unlockAllPlantShopItems() {
		gameManaging.GameManager.getShops().getPlantShop().unlockAll();
	}
	
	public static int getCompletedTaskCount() {
		return gameManaging.GameManager.getTaskManager().getCompletedTaskCount();
	}
	
	public static int getTaskCount() {
		return gameManaging.GameManager.getTaskManager().getTaskCount();
	}
	
	public static Vector3f getTerrainPickerRay() {
		return gameManaging.GameManager.getTerrainPicker().getCurrentRay();
	}
	
	public static Vector3f getTerrainPickerPoint() {
		return gameManaging.GameManager.getTerrainPicker().getCurrentTerrainPoint();
	}
	
	public static Vector3f getTerrainPickerIntersectionWithPlane(float planeHeight) {
		return gameManaging.GameManager.getTerrainPicker().getIntersectionWithPlane(planeHeight);
	}
	
	public static Vector3f getTerrainPickerRayPoint(float disFromCam) {
		return gameManaging.GameManager.getTerrainPicker().getRayPoint(disFromCam);
	}
	
	public static float getTerrainPickerDistance() {
		return gameManaging.GameManager.getTerrainPicker().getTerrainDistance();
	}
	
	public static void notify(String title, String text, Texture texture, Sound sound) {
		EquilinoxGuis.notify(title, text, texture, sound);
	}
}
