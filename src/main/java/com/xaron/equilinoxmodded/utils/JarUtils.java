package com.xaron.equilinoxmodded.utils;

import java.io.File;

import com.xaron.equilinoxmodded.Main;

public final class JarUtils {

	private JarUtils() {}
	
	public static boolean extractFromJar(File file, String path) {
		int code = 0;
		try {
			code = Runtime.getRuntime().exec("jar xf " + file.getName() + " " + path).waitFor();
		} catch (Exception e) {
			Main.LOGGER.error("Error when extracting from jar file.", e);
			return false;
		}
		if (code != 0) {
			Main.LOGGER.error("Error when extracting from jar file. Error code: " + code);
			return false;
		}
		return true;
	}
	
	public static boolean injectToJar(File file, String source) {
		int code = 0;
		try {
			code = Runtime.getRuntime().exec("jar uf " + file.getName() + " " + source).waitFor();
		} catch (Exception e) {
			Main.LOGGER.error("Error when injecting file.", e);
			return false;
		}
		if (code != 0) {
			Main.LOGGER.error("Error when injecting file. Error code: " + code);
			return false;
		}
		return true;
	}
}
