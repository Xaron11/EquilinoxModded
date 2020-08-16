package com.xaron.equilinoxmodded.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

public class CsvWriter {
	
	private final String SEPARATOR = ";";
	private boolean newLine;
	private BufferedWriter writer;
	
	public CsvWriter(File file, boolean newLine, boolean append) throws IOException {
		writer = new BufferedWriter(new FileWriter(file, append));
		this.newLine = newLine;
	}
	
	public void nextLine() throws IOException {
		writer.newLine();
		newLine = true;
	}
	
	public void writeSeparator() throws IOException { 
		writer.write(SEPARATOR);
	}
	
	public void checkWriteSeparator() throws IOException { 
		if (newLine)
			newLine = false;
		else
			writeSeparator();
	}
	
	public void writeString(String string) throws IOException { 
		checkWriteSeparator();
		writer.write(string);
	}
	
	public void writeInt(int i) throws IOException { 
		checkWriteSeparator();
		writer.write(String.valueOf(i));
	}
	
	public void writeFloat(float f) throws IOException { 
		checkWriteSeparator();
		writer.write(String.valueOf(f));
	}
	
	public void writeLong(long l) throws IOException { 
		checkWriteSeparator();
		writer.write(String.valueOf(l));
	}
	
	public void writeBool(boolean bool) throws IOException { 
		if (bool)
			writeInt(1);
		else
			writeInt(0);
	}
	
	public void writeVector(Vector3f vector) throws IOException { 
		writeFloat(vector.x);
		writeFloat(vector.y);
		writeFloat(vector.z);
	}
	
	public void writeIntArray(int[] array) throws IOException { 
		int count = array.length;
		writeInt(count);
		for (int i = 0; i < count; i++) {
			writeInt(array[i]);
		}
	}
	
	public void writeFloatArray(float[] array) throws IOException { 
		int count = array.length;
		writeInt(count);
		for (int i = 0; i < count; i++) {
			writeFloat(array[i]);
		}
	}
	
	public void writeLabelString(String label, String string) throws IOException {
		writeString(label);
		writeString(string);
	}
	
	public void writeLabelInt(String label, int i) throws IOException {
		writeString(label);
		writeInt(i);
	}
	
	public void writeLabelFloat(String label, float f) throws IOException {
		writeString(label);
		writeFloat(f);
	}
	
	public void writeLabelLong(String label, long l) throws IOException {
		writeString(label);
		writeLong(l);
	}
	
	public void writeLabelBool(String label, boolean bool) throws IOException {
		writeString(label);
		writeBool(bool);
	}
	
	public void writeLabelVector(String label, Vector3f vector) throws IOException { 
		writeString(label);
		writeFloat(vector.x);
		writeFloat(vector.y);
		writeFloat(vector.z);
	}
	
	public void writeLabelIntArray(String label, int[] array) throws IOException { 
		writeString(label);
		int count = array.length;
		writeInt(count);
		for (int i = 0; i < count; i++) {
			writeInt(array[i]);
		}
	}
	
	public void writeLabelFloatArray(String label, float[] array) throws IOException { 
		writeString(label);
		int count = array.length;
		writeInt(count);
		for (int i = 0; i < count; i++) {
			writeFloat(array[i]);
		}
	}
	
	public void close() throws IOException { 
		writer.close(); 
	}
}
