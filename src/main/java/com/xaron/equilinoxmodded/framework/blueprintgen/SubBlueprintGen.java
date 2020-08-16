package com.xaron.equilinoxmodded.framework.blueprintgen;

import org.lwjgl.util.vector.Vector3f;


public class SubBlueprintGen {
	
	protected Vector3f mins;
	protected Vector3f maxs;
	protected float increaseFactor = 1.0f;
	protected boolean additive = false;
	protected ModelSectionGen[] sections;
	
	protected SubBlueprintGen() {}
	
	public float[] getData(float size) {
		int dataCount = 0;
		for (int i = 0; i < sections.length; i++) {
			dataCount += sections[i].vertices.length;
		}
	    dataCount = dataCount * 10;
	    float[] data = new float[dataCount];
	    int sectionsCount = sections.length;
	    int pointer = 0;
	    for (int k = 0; k < sectionsCount; k++) {
	      int vertexCount = sections[k].vertices.length;
	      Vector3f colour = sections[k].colour;
	      float wobbleFactor = sections[k].wobbleFactor;
	      for (int i = 0; i < vertexCount; i++) {
	        Vector3f position = sections[k].vertices[i];
	        data[pointer++] = position.x * size;
	        data[pointer++] = position.y * size;
	        data[pointer++] = position.z * size;
	        data[pointer++] = position.y * size * wobbleFactor;
	        Vector3f normal = sections[k].normals[i];
	        data[pointer++] = normal.x;
	        data[pointer++] = normal.y;
	        data[pointer++] = normal.z;
	        data[pointer++] = colour.x;
	        data[pointer++] = colour.y;
	        data[pointer++] = colour.z;
	      } 
	    } 
	    return data;
	}
}
