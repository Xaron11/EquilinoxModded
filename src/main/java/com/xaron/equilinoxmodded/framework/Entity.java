package com.xaron.equilinoxmodded.framework;

import org.lwjgl.util.vector.Vector3f;

import classification.Classification;
import componentArchitecture.Component;
import componentArchitecture.ComponentType;
import death.DeathAi;
import toolbox.Colour;

public class Entity {
	protected instances.Entity entity;
	
	public Entity(instances.Entity entity) {
		this.entity = entity;
	}
	
	public Component getComponent(ComponentType type) {
		return entity.getComponent(type);
	}
	
	public void die(DeathAi deathAi) {
		entity.die(deathAi, false);
	}
	
	public boolean isAnimal() {
		return entity.getBlueprint().isAnimal();
	}
	
	public Classification getClassification() {
		return entity.getBlueprint().getClassification();
	}
	
	public boolean hasComponent(ComponentType type) {
		return entity.hasComponent(type);
	}
	
	public Colour getColour() {
		return entity.getTinter().getColour();
	}
	
	public boolean hasTint() {
		return entity.getTinter().hasTint();
	}
	
	public boolean isDead() {
		return entity.isDead();
	}
	
	public int getDpPerMinute() {
		return entity.getDpCounter().getDpPerMinute();
	}
	
	public boolean producesDp() {
		return entity.getDpCounter().producesDp();
	}
	
	public void setBaseDpPerMin(int baseDp) {
		entity.getDpCounter().setBaseDpPerMin(baseDp);
	}
	
	public Vector3f getPosition() {
		return entity.getTransform().getPosition();
	}
	
	public float getScale() {
		return entity.getTransform().getScale();
	}
	
	public float getRotX() {
		return entity.getTransform().getRotX();
	}
	
	public float getRotY() {
		return entity.getTransform().getRotY();
	}
	
	public float getRotZ() {
		return entity.getTransform().getRotZ();
	}
	
	public float getTerrainHeight() {
		return entity.getTransform().getTerrainHeight();
	}
	
	public float getTerrainOrWaterHeight() {
		return entity.getTransform().getTerrainOrWaterHeight();
	}
	
	public void increasePosition(Vector3f change) {
		entity.getTransform().increasePosition(change);
	}
	
	public void increasePosition(float dx, float dy, float dz) {
		entity.getTransform().increasePosition(dx, dy, dz);
	}
	
	public void setScale(float scale) {
		entity.getTransform().setScale(scale);
	}
	
	public void increaseRotation(float dx, float dy, float dz) {
		entity.getTransform().increaseRotation(dx, dy, dz);
	}
	
	public boolean isGrabbed() {
		return entity.isGrabbed();
	}
	
	public boolean isStatic() {
		return entity.isStatic();
	}
	
	public boolean isVisible() {
		return entity.isVisible();
	}
	
	public void follow() {
		entity.follow();
	}
}
