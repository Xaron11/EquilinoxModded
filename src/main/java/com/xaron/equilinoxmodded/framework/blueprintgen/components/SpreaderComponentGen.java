package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

import com.xaron.equilinoxmodded.framework.CsvWriter;

import biomes.Biome;

public class SpreaderComponentGen extends ComponentGen {

	private Biome biome;
	private Vector3f colourOffsets;
	private float strength;
    private int distance;
	
	
	public SpreaderComponentGen(Biome biome, Vector3f colourOffsets, float strength, int distance) {
		super("SPREADER");
		this.biome = biome;
		this.colourOffsets = colourOffsets;
		this.strength = strength;
		this.distance = distance;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("biome", biome.ordinal());
		writer.writeLabelVector("colourOffsets", colourOffsets);
		writer.writeLabelFloat("strength", strength);
		writer.writeLabelInt("distance", distance);
	}

}
