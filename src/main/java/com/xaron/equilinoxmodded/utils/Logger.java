package com.xaron.equilinoxmodded.utils;

public class Logger {
	
	private String context;
	
	public Logger(String context) {
		this.context = context;
	}
	
	
	public void info(String message) {
		System.out.println("[" + context + " - INFO]: " + message);
	}
	
	public void warn(String message) {
		System.out.println("[" + context + " - WARN]: " + message);
	}
	
	public void error(String message) {
		System.out.println("[" + context + " - ERROR]: " + message);
	}
	
	public void error(String message, Exception exception) {
		System.out.println("[" + context + " - ERROR]: " + message);
		exception.printStackTrace();
	}
	
	public void stacktrace(Exception exception) {
		exception.printStackTrace();
	}
}
