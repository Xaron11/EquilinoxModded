package com.xaron.equilinoxmodded.framework.blueprintgen;

import java.io.File;
import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.blueprintgen.components.ComponentGen;



public final class BlueprintGenerator {
	
	private BlueprintGenerator() {}
	
	public static void generate(String fileName, BlueprintGen blueprint) throws IOException {
		
		File pathFile = new File("src/main/resources/res/entities");
		File file = new File(pathFile, fileName + ".txt");
		file.createNewFile();
		CsvWriter writer = new CsvWriter(file, true, false);
		writeBaseInfo(writer, blueprint);
		writer.nextLine();
		writeSubBlueprints(writer, blueprint);
		writer.nextLine();
		writeComponents(writer, blueprint);
		writer.close();
	}

	private static void writeBaseInfo(CsvWriter writer, BlueprintGen blueprint) throws IOException {
		writer.writeFloat(blueprint.size);
		writer.writeLabelInt("name", blueprint.overrideName);
		writer.writeLabelInt("id", blueprint.overrideMainModelIndex);
		writer.writeLabelBool("randomize", blueprint.randomizeModelStages);
		writer.writeLabelBool("alwaysVis", blueprint.alwaysVisible);
		writer.nextLine();
		writer.writeString(blueprint.classification);
		writer.nextLine();
		writer.writeBool(blueprint.underwater);
		writer.writeBool(blueprint.overwater);
		writer.writeFloat(blueprint.acceptableHeightOffset);
	}
	
	private static void writeSubBlueprints(CsvWriter writer, BlueprintGen blueprint) throws IOException {
		SubBlueprintGen[] subBlueprints = blueprint.getSubBlueprints();
		
		writer.writeInt(subBlueprints.length);
		for (int i = 0; i < subBlueprints.length; i++) {
			writeSubBlueprint(writer, subBlueprints[i]);
		}
	}
	
	private static void writeSubBlueprint(CsvWriter writer, SubBlueprintGen blueprint) throws IOException {
		writer.nextLine();
		writer.writeVector(blueprint.mins);
		writer.writeVector(blueprint.maxs);
		writer.writeFloat(blueprint.increaseFactor);
		writer.writeBool(blueprint.additive);
		writeModelData(writer, blueprint);
	}

	private static void writeModelData(CsvWriter writer, SubBlueprintGen blueprint) throws IOException {
		writer.nextLine();
		ModelSectionGen[] sections = blueprint.sections;
		int dataCount = 0;
		for (int i = 0; i < sections.length; i++) {
			dataCount += sections[i].vertices.length;
		}
		writer.writeInt(dataCount);
		
		writer.writeInt(sections.length);
		for (int i = 0; i < sections.length; i++) {
			writer.nextLine();
			Vector3f[] vertices = sections[i].vertices;
			writer.writeInt(vertices.length);
			writer.writeVector(sections[i].colour);
			writer.writeFloat(sections[i].wobbleFactor);
			writer.nextLine();
			
			for (int j = 0; j < vertices.length; j++) {
				writer.writeVector(vertices[j]);
				writer.writeVector(sections[i].normals[j]);
			}
		}
	}
	
	private static void writeComponents(CsvWriter writer, BlueprintGen blueprint) throws IOException {
		ComponentGen[] components = blueprint.getComponents();
		
		writer.writeInt(components.length);
		for (int i = 0; i < components.length; i++) {
			writer.nextLine();
			components[i].writeComponent(writer);
		}
	}
}
