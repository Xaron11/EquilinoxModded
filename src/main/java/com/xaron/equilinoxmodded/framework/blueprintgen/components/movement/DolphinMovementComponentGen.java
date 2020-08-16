package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class DolphinMovementComponentGen extends MovementComponentGen {

	private float speed;
	private int xRot;
	private float minRot;
	private float maxRot;
	private float rotSpeed;
	private Float swimHeight;
	private Boolean eggStage;
	private Float swimFactor;
	private Float swimInertia;
	
	public DolphinMovementComponentGen(float speed, int xRot, float minRot, float maxRot, float rotSpeed, float swimHeight, boolean eggStage, float swimFactor, float swimInertia) {
		super(9);
		this.speed = speed;
		this.xRot = xRot;
		this.minRot = minRot;
		this.maxRot = maxRot;
		this.rotSpeed = rotSpeed;
		this.swimHeight = swimHeight;
		this.eggStage = eggStage;
		this.swimFactor = swimFactor;
		this.swimInertia = swimInertia;
	}
	
	public DolphinMovementComponentGen(float speed, int xRot, float minRot, float maxRot, float rotSpeed, float swimHeight, boolean eggStage, float swimFactor) {
		super(9);
		this.speed = speed;
		this.xRot = xRot;
		this.minRot = minRot;
		this.maxRot = maxRot;
		this.rotSpeed = rotSpeed;
		this.swimHeight = swimHeight;
		this.eggStage = eggStage;
		this.swimFactor = swimFactor;
		this.swimInertia = null;
	}
	
	public DolphinMovementComponentGen(float speed, int xRot, float minRot, float maxRot, float rotSpeed, float swimHeight) {
		super(9);
		this.speed = speed;
		this.xRot = xRot;
		this.minRot = minRot;
		this.maxRot = maxRot;
		this.rotSpeed = rotSpeed;
		this.swimHeight = swimHeight;
		this.eggStage = null;
		this.swimFactor = null;
		this.swimInertia = null;
	}
	
	public DolphinMovementComponentGen(float speed, int xRot, float minRot, float maxRot, float rotSpeed) {
		super(9);
		this.speed = speed;
		this.xRot = xRot;
		this.minRot = minRot;
		this.maxRot = maxRot;
		this.rotSpeed = rotSpeed;
		this.swimHeight = null;
		this.eggStage = null;
		this.swimFactor = null;
		this.swimInertia = null;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("speed", speed);
		writer.writeLabelInt("xRot", xRot);
		writer.writeLabelFloat("minRot", minRot);
		writer.writeLabelFloat("maxRot", maxRot);
		writer.writeLabelFloat("rotSpeed", rotSpeed);
		if (swimHeight != null)
			writer.writeLabelFloat("swimHeight", swimHeight);
		if (eggStage != null)
			writer.writeLabelBool("eggStage", eggStage);
		if (swimFactor != null)
			writer.writeLabelFloat("swimFactor", swimFactor);
		if (swimInertia != null)
			writer.writeLabelFloat("swimInertia", swimInertia);
	}
}
