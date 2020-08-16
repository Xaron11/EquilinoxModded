package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class FlouncerMovementComponentGen extends MovementComponentGen {

	private float speed;
	private float rotSpeed;
	private float bouncePower;
	private float bounceRotation;
	private float standardHeight;
	
	public FlouncerMovementComponentGen(float speed, float rotSpeed, float bouncePower, float bounceRotation, float standardHeight) {
		super(8);
		this.speed = speed;
		this.rotSpeed = rotSpeed;
		this.bouncePower = bouncePower;
		this.bounceRotation = bounceRotation;
		this.standardHeight = standardHeight;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("speed", speed);
		writer.writeLabelFloat("rotSpeed", rotSpeed);
		writer.writeLabelFloat("bouncePower", bouncePower);
		writer.writeLabelFloat("bounceRotation", bounceRotation);
		writer.writeLabelFloat("standardHeight", standardHeight);
	}
}
