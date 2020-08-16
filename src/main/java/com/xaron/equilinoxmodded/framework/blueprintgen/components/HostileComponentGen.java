package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.GameRepository.Classification;


public class HostileComponentGen extends ComponentGen {

	private float averageAttackTime;
	private Classification enemyClassification;
	private boolean notify;
	
	public enum FightAnimation
	{
		Lunge,
		Sting
	}
	
	public HostileComponentGen(float averageAttackTime, Classification enemyClassification, boolean notify) {
		super("HOSTILE");
		this.averageAttackTime = averageAttackTime;
		this.enemyClassification = enemyClassification;
		this.notify = notify;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelFloat("averageAttackTime", averageAttackTime);
		writer.writeLabelString("enemyClassification", enemyClassification.get());
		writer.writeLabelBool("notify", notify);
	}

}
