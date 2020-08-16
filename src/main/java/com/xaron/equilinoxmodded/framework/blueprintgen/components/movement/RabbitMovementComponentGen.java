package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class RabbitMovementComponentGen extends MovementComponentGen {

	private float speed;
	private float bouncePower;
	private float upRotSpeed;
	private float downRotSpeed;
	private Vector3f frontZ;
	private Vector3f backZ;
	
	public RabbitMovementComponentGen(float speed, float bouncePower, float upRotSpeed, float downRotSpeed, Vector3f frontZ, Vector3f backZ) {
		super(7);
		this.speed = speed;
		this.bouncePower = bouncePower;
		this.upRotSpeed = upRotSpeed;
		this.downRotSpeed = downRotSpeed;
		this.frontZ = frontZ;
		this.backZ = backZ;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("speed", speed);
		writer.writeLabelFloat("bouncePower", bouncePower);
		writer.writeLabelFloat("upRotSpeed", upRotSpeed);
		writer.writeLabelFloat("downRotSpeed", downRotSpeed);
		writer.writeLabelVector("frontZ", frontZ);
		writer.writeLabelVector("backZ", backZ);
	}
}
