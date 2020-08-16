package com.xaron.equilinoxmodded.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.xaron.equilinoxmodded.Main;

public final class FileUtils {

	public static final String BACKUPDIRNAME = "backup";
	public static final String MODSDIRNAME = "mods";
	public static final String GAMEFILENAME = "EquilinoxWindows.jar";
	public static final String TMPFILENAME = "EquilinoxWindows.jar.tmp";
	public static final String BACKUPFILENAME = "EquilinoxWindows.jar.backup";
	public static final String PATCHESFILENAME = "patches.txt";
	
	public static final File SOURCEFILE = getSourceDirectory();
	public static final File MAINDIR = SOURCEFILE.getParentFile();
	public static final File GAMEFILE = new File(MAINDIR, GAMEFILENAME);
	public static final File BACKUPDIR = new File(MAINDIR, BACKUPDIRNAME);
	public static final File BACKUPFILE = new File(BACKUPDIR, BACKUPFILENAME);
	public static final File MODSDIR = new File(MAINDIR, MODSDIRNAME);
	public static final File TMPFILE = new File(MAINDIR, TMPFILENAME);
	
	private FileUtils() {}
	
	public static File getSourceDirectory() {
		return new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	}
	
	public static boolean copyGameFile()
	{
		try {
			Files.copy(FileUtils.GAMEFILE.toPath(), FileUtils.TMPFILE.toPath());
		} catch (IOException e) {
			Main.LOGGER.error("Error when copying game file.", e);
			return false;
		}
		
		return true;
	}
	
	public static void createModsDirectory() {
		try {
			if (!Files.exists(FileUtils.MODSDIR.toPath())) {
				Files.createDirectory(FileUtils.MODSDIR.toPath());
			}
		} catch (IOException e) {
			Main.LOGGER.error("Error when creating mods directory.", e);
		}
	}
	
	/*
	public static boolean backupGameFile() {
		try {
			if (!Files.exists(FileUtils.BACKUPDIR.toPath())) {
				Files.createDirectory(FileUtils.BACKUPDIR.toPath());
			}
			
			if (!Files.exists(BACKUPFILE.toPath())) {
				Files.copy(GAMEFILE.toPath(), BACKUPFILE.toPath());
				Main.LOGGER.info("Backup created.");
			}
			else {
				Main.LOGGER.info("Backup already exist.");
			}
			return true;
		} catch (IOException e) {
			Main.LOGGER.error("Error when creating backup file.", e);
			return false;
		}
	}
	*/
	
	public static void clear(File file) {
		if (file.isDirectory()) {
			for (File innerFile : file.listFiles()) {
				clear(innerFile);
			}
		}

		if (!file.delete()) {
			Main.LOGGER.warn("Can't delete file: " + file.getAbsolutePath());
		}
	}
}
