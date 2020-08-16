package com.xaron.equilinoxmodded.framework.blueprintgen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.util.vector.Vector3f;

public final class ModelGenerator {

	private ModelGenerator() {}
	
	public static SubBlueprintGen generate(String modelFileName) throws IOException  {
		String file = "/res/models/" + modelFileName + ".obj";
		BufferedReader reader = new BufferedReader(new InputStreamReader(ModelGenerator.class.getResourceAsStream(file)));
		
		SubBlueprintGen subBlueprint = new SubBlueprintGen();
		
		List<ModelSectionGen> sections = new ArrayList<ModelSectionGen>();
		
		ModelSectionGen currentSection = null;
		List<Vector3f> vertices = new ArrayList<Vector3f>();
		List<Vector3f> normals = new ArrayList<Vector3f>();
		Vector3f colour = new Vector3f(0f, 0f, 0f);
		Vector3f[] verticesArray = null;
		Vector3f[] normalsArray = null;
		boolean allVerticesRead = false;
		int vertexPointer = 0;
		
		Map<String, Vector3f> materials = new HashMap<String, Vector3f>();
		
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("# "))
				continue;
			
			String[] currentLine = line.split(" ");
			
			if (line.startsWith("mtllib ")) {
				materials = readMaterialFile(currentLine[1]);
			}
			else if (line.startsWith("o ")) {
				if (currentSection != null) {
					currentSection.vertices = verticesArray;
					currentSection.normals = normalsArray;
					currentSection.colour = colour;
					sections.add(currentSection);
					vertices.clear();
					normals.clear();
					colour.set(0f, 0f, 0f);
					allVerticesRead = false;
					vertexPointer = 0;
				}
				
				currentSection = new ModelSectionGen();
				
			}
			else if (line.startsWith("v ")) {
				vertices.add(new Vector3f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]), Float.parseFloat(currentLine[3])));
				//System.out.println("Vertex read: " + new Vector3f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]), Float.parseFloat(currentLine[3])));
			}
			else if (line.startsWith("vn ")) {
				normals.add(new Vector3f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]), Float.parseFloat(currentLine[3])));
				//System.out.println("Normal read: " + new Vector3f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]), Float.parseFloat(currentLine[3])));
			}
			else if (line.startsWith("usemtl ")) {
				colour = materials.get(currentLine[1]);
				//System.out.println("Material: " + materials.containsKey(currentLine[1]));
				//System.out.println("Colour read: " + colour.toString());
			}
			else if (line.startsWith("f ")) {
				if (!allVerticesRead) {
					verticesArray = new Vector3f[vertices.size() * 3];
					//System.out.println("Vertices array set: " + vertices.size() * 3);
					normalsArray = new Vector3f[normals.size() * 3];
					//System.out.println("Normals array set: " + normals.size() * 3);
					allVerticesRead = true;
				}
				String[] vertex1 = currentLine[1].split("//");
				String[] vertex2 = currentLine[2].split("//");
				String[] vertex3 = currentLine[3].split("//");
				
				processVertex(verticesArray, normalsArray, vertices, normals, vertexPointer, vertex1);
				vertexPointer++;
				processVertex(verticesArray, normalsArray, vertices, normals, vertexPointer, vertex2);
				vertexPointer++;
				processVertex(verticesArray, normalsArray, vertices, normals, vertexPointer, vertex3);
				vertexPointer++;
			}
			
		}
		reader.close();
		
		currentSection.vertices = verticesArray;
		currentSection.normals = normalsArray;
		currentSection.colour = colour;
		sections.add(currentSection);
		
		subBlueprint.sections = sections.toArray(new ModelSectionGen[sections.size()]);
		//System.out.println("SubBlueprint Sections length: " + subBlueprint.sections.length);
		Vector3f[] minsAndMaxs = GetMinsAndMaxs(subBlueprint);
		subBlueprint.mins = minsAndMaxs[0];
		subBlueprint.maxs = minsAndMaxs[1];
		
		return subBlueprint;
	}
	
	private static void processVertex(Vector3f[] verticesArray, Vector3f[] normalsArray, List<Vector3f> vertices, List<Vector3f> normals, int vertexPointer, String[] vertex) {
		verticesArray[vertexPointer] = vertices.get(Integer.parseInt(vertex[0]) - 1);
		normalsArray[vertexPointer] = normals.get(Integer.parseInt(vertex[1]) - 1);
	}
	
	private static Vector3f[] GetMinsAndMaxs(SubBlueprintGen subBlueprint) {
		float minX, minY, minZ;
		minX = minY = minZ = Float.MAX_VALUE;
		float maxX, maxY, maxZ;
		maxX = maxY = maxZ = Float.MIN_VALUE;
		
		for (int i = 0; i < subBlueprint.sections.length; i++) {
			Vector3f[] sectionVertices = subBlueprint.sections[i].vertices;
			//System.out.println("Section Vertices elements: " + sectionVertices[0].toString());
			for (int j = 0; j < sectionVertices.length; j++) {
				Vector3f vertex = sectionVertices[j];
				//System.out.println("Section Vertices length: " + sectionVertices.length);
				if (vertex.x < minX) minX = vertex.x;
				if (vertex.y < minY) minY = vertex.y;
				if (vertex.z < minZ) minZ = vertex.z;
				
				if (vertex.x > maxX) maxX = vertex.x;
				if (vertex.y > maxY) maxY = vertex.y;
				if (vertex.z > maxZ) maxZ = vertex.z;
			}
		}
		
		Vector3f[] minsAndMaxs = new Vector3f[] {new Vector3f(minX, minY, minZ), new Vector3f(maxX, maxY, maxZ)};
		return minsAndMaxs;
	}
	
	private static Map<String, Vector3f> readMaterialFile(String fileName) throws IOException {
		String file = "/res/models/" + fileName;
		BufferedReader reader = new BufferedReader(new InputStreamReader(ModelGenerator.class.getResourceAsStream(file)));
		
		List<String> matNames = new ArrayList<String>();
		List<Vector3f> matColours = new ArrayList<Vector3f>();
		
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("# "))
				continue;
			
			String[] currentLine = line.split(" ");
			
			if (line.startsWith("newmtl ")) {
				matNames.add(currentLine[1]);
			}
			else if (line.startsWith("Kd ")) {
				matColours.add(new Vector3f(Float.parseFloat(currentLine[1]), Float.parseFloat(currentLine[2]), Float.parseFloat(currentLine[3])));
			}
		}
		reader.close();
		
		Map<String, Vector3f> materials = new HashMap<String, Vector3f>();
		for (int i = 0; i < matNames.size(); i++) {
			materials.put(matNames.get(i), matColours.get(i));
		}
		
		return materials;
	}
}
