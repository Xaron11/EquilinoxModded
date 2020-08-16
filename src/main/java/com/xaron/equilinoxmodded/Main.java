package com.xaron.equilinoxmodded;
import java.io.*;

import com.xaron.equilinoxmodded.patcher.GamePatcher;
import com.xaron.equilinoxmodded.utils.FileUtils;
import com.xaron.equilinoxmodded.utils.JarUtils;
import com.xaron.equilinoxmodded.utils.Logger;

public class Main {
	
	public static final String EQUILINOXMODDEDID = "EQM";
	
	public static final Logger LOGGER = new Logger(EQUILINOXMODDEDID);
	
	public static void main(String[] args) {
		
		LOGGER.info("Running EquilinoxModded...");
		
		/*
		if (args.length != 0 && args[0].contains("restore")) {
			LOGGER.info("Restoring game backup...");
			try {
				FileUtils.clear(new File(FileUtils.GAMEFILENAME));
				Files.copy(FileUtils.BACKUPFILE.toPath(), FileUtils.GAMEFILE.toPath());
			} catch (IOException e) {
				LOGGER.error("Error when restoring game backup.", e);
			}
			return;
		}
		*/
		
		if (args.length != 0 && args[0].contains("install")) {
			FileUtils.createModsDirectory();
			
			LOGGER.info("Patching game file...");
			GamePatcher patcher = new GamePatcher();
			patcher.run();
			if (patcher.successed())
				LOGGER.info("Game patched.");
			else {
				LOGGER.error("Game has not been patched.");
				return;
			}
			
			LOGGER.info("Extracting framework files...");
			if (!JarUtils.extractFromJar(FileUtils.SOURCEFILE, "com/xaron")) {
				LOGGER.error("Error when extracting framework files.");
				return;
			}
			
			LOGGER.info("Injecting framework files into temporary file...");
			if (!JarUtils.injectToJar(FileUtils.TMPFILE, "com")) {
				LOGGER.error("Error when injecting framework files.");
				return;
			}
			
			LOGGER.info("Post-injection cleaning...");
			FileUtils.clear(new File("com"));
			if (!FileUtils.TMPFILE.renameTo(new File(FileUtils.GAMEFILENAME.replace(".jar", " - Modded.jar"))))
				LOGGER.warn("Can't rename temporary file.");
			
			LOGGER.info("Finished.");
		}
	}
}
