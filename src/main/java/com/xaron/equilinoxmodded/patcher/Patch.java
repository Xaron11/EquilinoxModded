package com.xaron.equilinoxmodded.patcher;

import com.xaron.equilinoxmodded.Main;

public class Patch {

	public enum PatchPlace {
		start,
		end,
		line;
	}
	
	public enum PatchAttribute {
		apublic(1),
		aprotected(4),
		aprivate(2);

		public int mod;
		
		PatchAttribute(int mod) {
			this.mod = mod;
		}
	}
	
	public int patchClass = -1;
	public int patchMethod = -1;
	public int patchCode = -1;
	public int patchPlace = -1;
	public int patchAttribute = -1;
	public int patchLine = -1;
	public int patchParams = -1;
	
	private String[] parts;
	
	public Patch(String[] parts) {
		this.parts = parts;
	}
	
	public String getPatchClass() {
		return parts[patchClass];
	}
	
	public String getPatchMethod() {
		return parts[patchMethod];
	}
	
	public boolean isPatchConstructor() {
		return parts[patchMethod] == "constructor";
	}
	
	public boolean hasPatchParams() {
		return patchParams != -1;
	}
	
	public String getPatchCode() {
		return parts[patchCode];
	}
	
	public int getPatchLine() {
		return Integer.parseInt(parts[patchLine]);
	}
	
	public String[] getPatchParams() {
		return parts[patchParams].split("\\,");
	}
	
	public PatchPlace getPatchPlace() {
		PatchPlace place;
		try {
			place = Enum.valueOf(Patch.PatchPlace.class, parts[patchPlace]);
		} catch (IllegalArgumentException e) {
			place = Patch.PatchPlace.end;
			Main.LOGGER.warn("Wrong patch place value. Defaulting to: 'end'");
		}
		return place;
	}
	
	public PatchAttribute getPatchAttribute() {
		PatchAttribute attr;
		try {
			attr = Enum.valueOf(Patch.PatchAttribute.class, "a" + parts[patchAttribute]);
		} catch (IllegalArgumentException e) {
			attr = Patch.PatchAttribute.apublic;
			Main.LOGGER.warn("Wrong patch attribute value. Defaulting to: 'public'");
		}
		return attr;
	}
}
