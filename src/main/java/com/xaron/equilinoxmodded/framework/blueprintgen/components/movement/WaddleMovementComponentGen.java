package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class WaddleMovementComponentGen extends MovementComponentGen {

	private float speed;
	private float rotSpeed;
	private float bouncePower;
	
	public WaddleMovementComponentGen(float speed, float rotSpeed, float bouncePower) {
		super(15);
		this.speed = speed;
		this.rotSpeed = rotSpeed;
		this.bouncePower = bouncePower;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("speed", speed);
		writer.writeLabelFloat("rotSpeed", rotSpeed);
		writer.writeLabelFloat("bouncePower", bouncePower);
	}
}
