package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class RockingMovementComponentGen extends MovementComponentGen {

	private float speed;
	private int xRot;
	private float minRot;
	private float maxRot;
	private float rotSpeed;
	
	public RockingMovementComponentGen(float speed, int xRot, float minRot, float maxRot, float rotSpeed) {
		super(45);
		this.speed = speed;
		this.xRot = xRot;
		this.minRot = minRot;
		this.maxRot = maxRot;
		this.rotSpeed = rotSpeed;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("speed", speed);
		writer.writeLabelInt("xRot", xRot);
		writer.writeLabelFloat("minRot", minRot);
		writer.writeLabelFloat("maxRot", maxRot);
		writer.writeLabelFloat("rotSpeed", rotSpeed);
	}
}
