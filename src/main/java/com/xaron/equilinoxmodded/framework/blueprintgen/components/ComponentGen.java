package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;

public class ComponentGen {
	
	public enum Component {
		BEAVER,
		BIRDHUNT,
		TONGUESHOOT,
		LILY,
		NAME,
		FISHHUNT,
		BEE
	}
	
	private String type;
	
	public ComponentGen(String type) {
		this.type = type;
	}
	
	public ComponentGen(Component type) {
		this.type = type.name();
	}
	
	public void writeComponent(CsvWriter writer) throws IOException {
		writer.writeString(type);
	}
	
	public void writeRequirement(CsvWriter writer) throws IOException {
		writer.writeString(type);
	}
}