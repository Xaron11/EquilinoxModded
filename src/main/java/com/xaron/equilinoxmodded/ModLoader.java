package com.xaron.equilinoxmodded;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;
import java.util.*;
import java.util.jar.*;

import com.xaron.equilinoxmodded.framework.Mod;
import com.xaron.equilinoxmodded.framework.events.Event;
import com.xaron.equilinoxmodded.framework.events.EventBus;
import com.xaron.equilinoxmodded.framework.events.EventHandler;
import com.xaron.equilinoxmodded.utils.FileUtils;

public class ModLoader {
	
	private Set<File> modFiles = new HashSet<File>();
	private Set<Class<?>> modClasses = new HashSet<Class<?>>();
	private Set<Mod> mods = new HashSet<Mod>();
	
	public ModLoader() {
		scanForModFiles(FileUtils.MODSDIR.toPath());
		scanModFiles();
		loadMods();
	}
	
	private void scanForModFiles(Path modsPath) {
		Main.LOGGER.info("Scanning for mods...");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(modsPath)) {
			for (Path file : stream) {
				File modFile = file.toFile();
				String fileName = modFile.getName();
				if (fileName.endsWith(".jar") || fileName.endsWith(".zip")) {
					modFiles.add(modFile);
					Main.LOGGER.info("Found mod file: " + fileName);
				}
			}
		} catch (Exception e) {
			Main.LOGGER.error("Error when searching mods directory.", e);
		}
		Main.LOGGER.info("Found: " + this.modFiles.size() + " mod files.");
	}
	
	private void scanModFiles() {
		Main.LOGGER.info("Scanning mod files...");
		try {
			URLClassLoader loader = (URLClassLoader)getClass().getClassLoader();
			Method addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			addURLMethod.setAccessible(true);
			
			for (File file : this.modFiles) {
				JarFile jarFile = new JarFile(file);
				Collection<JarEntry> entries = getJarEntries(jarFile);
				URLClassLoader urlClassLoader = getUrlClassLoader(file);
				
				for (JarEntry entry : entries) {
					
					Class<?> modClass = loadModClass(urlClassLoader, entry);

					if (modClass == null) {
						continue;
					}

					if (modClass.isAnnotationPresent(Mod.class)) {
						this.modClasses.add(modClass);
						Main.LOGGER.info("Found Mod class: " + modClass.getName());
						addURLMethod.invoke(loader, new URL("jar:file:" + file.getAbsolutePath() + "!/"));
						Main.LOGGER.info("Loaded mod resources for: " + modClass.getName());
					}
				}
			}
		} catch (Exception e) {
			Main.LOGGER.error("Error when scanning mod files.", e);
		}
		Main.LOGGER.info("Found: " + this.modClasses.size() + " mod classes.");
		
	}
	
	private void loadMods() {
		try {
			Main.LOGGER.info("Loading mods...");
			for (Class<?> modClass : this.modClasses) {
				Object instance = modClass.newInstance();
				Mod mod = modClass.getAnnotation(Mod.class);
				this.mods.add(mod);
				loadEventHandlers(modClass, instance);
				Main.LOGGER.info("Loaded mod: " + mod.MODNAME());
			}
		} catch (Exception e) {
			Main.LOGGER.error("Error when loading mods.", e);
		}
	}
	
	private void loadEventHandlers(Class<?> modClass, Object classInstance) {
		for (Method method : modClass.getMethods()) {
			if (method.isAnnotationPresent(EventHandler.class)) {
				Class<?>[] parameters = method.getParameterTypes();
				if (parameters.length != 1) 
					continue;
				if (Event.class.isAssignableFrom(parameters[0])) {
					EventBus.addListener(parameters[0], classInstance, method);
				}
			}
		}
	}

	private Collection<JarEntry> getJarEntries(JarFile jarFile) {
		Collection<JarEntry> jarEntries = new HashSet<>();
		Enumeration<JarEntry> entries = jarFile.entries();

		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			jarEntries.add(entry);
		}

		return jarEntries;
	}
	
	private URLClassLoader getUrlClassLoader(File file) throws MalformedURLException {
		URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] { new URL("jar:file:" + file.getAbsolutePath() + "!/") });
		return urlClassLoader;
	}
	
	private Class<?> loadModClass(URLClassLoader urlClassLoader, JarEntry entry) throws ClassNotFoundException {
		if (!entry.getName().endsWith(".class")) {
			return null;
		}
		
		String className = entry.getName().substring(0, entry.getName().length() - 6);
		className = className.replace('/', '.');
		Class<?> modClass = urlClassLoader.loadClass(className);
		return modClass;
	}
}
