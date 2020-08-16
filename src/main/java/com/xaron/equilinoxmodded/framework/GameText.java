package com.xaron.equilinoxmodded.framework;

public class GameText {

	private int id;
	private String text;
	
	protected GameText(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}
}
