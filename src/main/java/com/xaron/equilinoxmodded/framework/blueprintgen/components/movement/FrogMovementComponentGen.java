package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class FrogMovementComponentGen extends MovementComponentGen {

	private float speed;
	private float bouncePower;
	private float waitTime;
	private float bounciness;
	
	public FrogMovementComponentGen(float speed, float bouncePower, float waitTime, float bounciness) {
		super(6);
		this.speed = speed;
		this.bouncePower = bouncePower;
		this.waitTime = waitTime;
		this.bounciness = bounciness;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("speed", speed);
		writer.writeLabelFloat("bouncePower", bouncePower);
		writer.writeLabelFloat("waitTime", waitTime);
		writer.writeLabelFloat("bounciness", bounciness);
	}
}
