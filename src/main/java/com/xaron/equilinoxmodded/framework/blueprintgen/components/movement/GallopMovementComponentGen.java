package com.xaron.equilinoxmodded.framework.blueprintgen.components.movement;

import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class GallopMovementComponentGen extends MovementComponentGen {

	private float speed;
	private float bouncepPow;
	private float upRotSpeed;
	private float gravityFactor;
	private Vector3f frontZ;
	private Vector3f backZ;
	private float runFactor = 2.0F;
	
	public GallopMovementComponentGen(float speed, float bouncepPow, float upRotSpeed, float gravityFactor, Vector3f frontZ, Vector3f backZ, float runFactor) {
		super(13);
		this.speed = speed;
		this.bouncepPow = bouncepPow;
		this.upRotSpeed = upRotSpeed;
		this.gravityFactor = gravityFactor;
		this.frontZ = frontZ;
		this.backZ = backZ;
		this.runFactor = runFactor;
	}
	
	public GallopMovementComponentGen(float speed, float bouncepPow, float upRotSpeed, float gravityFactor, Vector3f frontZ, Vector3f backZ) {
		super(13);
		this.speed = speed;
		this.bouncepPow = bouncepPow;
		this.upRotSpeed = upRotSpeed;
		this.gravityFactor = gravityFactor;
		this.frontZ = frontZ;
		this.backZ = backZ;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("speed", speed);
		writer.writeLabelFloat("bouncepPow", bouncepPow);
		writer.writeLabelFloat("upRotSpeed", upRotSpeed);
		writer.writeLabelFloat("gravityFactor", gravityFactor);
		writer.writeLabelVector("frontZ", frontZ);
		writer.writeLabelVector("backZ", backZ);
		writer.writeLabelFloat("runFactor", runFactor);
	}
}
