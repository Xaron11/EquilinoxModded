package com.xaron.equilinoxmodded.framework;


import inventory.Inventory;
import saves.SaveSlot;
import session.GameMode;
import time.Calendar;

public class Session {
	private session.Session session;
	
	protected Session(session.Session session) {
		this.session = session;
	}
	
	public Inventory getInventory() {
		return session.getInventory();
	}
	
	public GameMode getMode() {
		return session.getMode();
	}
	
	public SaveSlot getSave() {
		return session.getSave();
	}
	
	public int getDpCount() {
		return session.getStats().getDpCount();
	}
	
	public int getDpPerMinute() {
		return session.getStats().getDpPerMinute();
	}
	
	public void increaseDp(int increase) {
		session.getStats().increaseDp(increase);
	}
	
	public void setDpPerMinute(int amount) {
		session.getStats().setDpPerMinute(amount);
	}
	
	public Calendar getCalendar() {
		return session.getStats().getCalendar();
	}
	
	public World getWorld() {
		return new World(session.getWorld());
	}
}
