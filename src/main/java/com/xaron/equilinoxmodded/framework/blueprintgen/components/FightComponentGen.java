package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;


public class FightComponentGen extends ComponentGen {

	private int attackDamage;
	private boolean revenge;
	private FightAnimation anim;
	private float biteRange;
	private float pauseTime;
	
	public enum FightAnimation
	{
		Lunge,
		Sting
	}
	
	public FightComponentGen(int attackDamage, boolean revenge, FightAnimation anim, float biteRange, float pauseTime) {
		super("FIGHT");
		this.attackDamage = attackDamage;
		this.revenge = revenge;
		this.anim = anim;
		this.biteRange = biteRange;
		this.pauseTime = pauseTime;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("attackDamage", attackDamage);
		writer.writeLabelBool("revenge", revenge);
		writer.writeLabelInt("anim", anim.ordinal());
		writer.writeLabelFloat("biteRange", biteRange);
		writer.writeLabelFloat("pauseTime", pauseTime);
	}

}
