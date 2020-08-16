package com.xaron.equilinoxmodded.patcher;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.jar.*;
import java.util.stream.Stream;

import com.xaron.equilinoxmodded.Main;
import com.xaron.equilinoxmodded.patcher.Patch.PatchPlace;
import com.xaron.equilinoxmodded.utils.FileUtils;
import com.xaron.equilinoxmodded.utils.JarUtils;

import javassist.*;

public class GamePatcher {
	
	private Collection<Patch> patches;
	private Map<String, byte[]> patchedClasses = new HashMap<>();
	
	public void run() {
		success = true;
		patches = readPatches();
		if (success)
			processPatches();
		if (success)
			injectPatchedClasses();
		
	}
	
	private boolean success;
	
	public boolean successed()
	{
		return success;
	}
	
	private Collection<Patch> readPatches() {
		Main.LOGGER.info("Reading patches...");
		Collection<Patch> patches = new HashSet<>();
		try (JarFile jarFile = new JarFile(FileUtils.SOURCEFILE)) {
			
			JarEntry patchesEntry = jarFile.getJarEntry(FileUtils.PATCHESFILENAME);
			InputStream stream = jarFile.getInputStream(patchesEntry);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			Stream<String> lines = reader.lines().filter(line -> !line.startsWith("#"));

			lines.forEach(line -> {
				Main.LOGGER.info("Reading patch: '" + line + "'");
				Patch patch = parsePatch(line);
				patches.add(patch);
				Main.LOGGER.info("Patch read.");
			});
		} catch (IOException e) {
			Main.LOGGER.error("Error when reading patches.", e);
			success = false;
		}
		return patches;
	}
	
	private Patch parsePatch(String line) {
		Main.LOGGER.info("Parsing patch...");
		String[] patchParts = line.split("\\|");
		
		Patch patch = new Patch(patchParts);
		patch.patchClass = 0;
		patch.patchMethod = 1;
		if (patch.isPatchConstructor()) {
			patch.patchAttribute = 2;
		}
		else {
			patch.patchPlace = 2;
			if (patch.getPatchPlace() == PatchPlace.line) {
				patch.patchLine = 3;
				patch.patchCode = 4;
				if (patchParts.length == 6)
					patch.patchParams = 5;
			}
			else {
				patch.patchCode = 3;
				if (patchParts.length == 5)
					patch.patchParams = 4;
			}
		}
		
		return patch;
	}
	
	private void processPatches() {
		Main.LOGGER.info("Processing patches...");
		try (JarFile jarFile = new JarFile(FileUtils.GAMEFILE)) {
			for (Patch patch : this.patches) {
				Main.LOGGER.info("Executing patch for class: " + patch.getPatchClass() + ", for method: " + patch.getPatchMethod() + "...");

				InputStream stream = null;

				if (!this.patchedClasses.containsKey(patch.getPatchClass())) {
					JarEntry jarEntry = jarFile.getJarEntry(patch.getPatchClass());
					stream = jarFile.getInputStream(jarEntry);
				} else {
					byte[] patchedClass = this.patchedClasses.get(patch.getPatchClass());
					stream = new ByteArrayInputStream(patchedClass);
				}

				byte[] patchedClass = patchClass(stream, patch);
				patchedClasses.put(patch.getPatchClass(), patchedClass);

				Main.LOGGER.info("Class patched.");
			}
		} catch (Exception e) {
			Main.LOGGER.error("Error when patching classes.", e);
			success = false;
			return;
		}
	}
	
	private byte[] patchClass(InputStream stream, Patch patch) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		pool.insertClassPath(FileUtils.GAMEFILENAME);

		CtClass ctClass = pool.makeClass(stream);
		
		if (patch.isPatchConstructor()) {
			CtConstructor[] constructors = ctClass.getDeclaredConstructors();
			for (int i = 0; i < constructors.length; i++) {
				constructors[i].setModifiers(patch.getPatchAttribute().mod);
			}
		}
		else {
			CtMethod method;
			if (patch.hasPatchParams()) {
				method = findMethod(ctClass, patch);
			}
			else {
				method = ctClass.getDeclaredMethod(patch.getPatchMethod());
			}

			switch (patch.getPatchPlace()) {
			case start:
				method.insertBefore(patch.getPatchCode());
				break;
			case end:
				method.insertAfter(patch.getPatchCode());
				break;
			case line:
				method.insertAt(patch.getPatchLine(), patch.getPatchCode());
				break;
			default:
				break;
			}
		}
		
		byte[] modifiedClass = ctClass.toBytecode();
		if (ctClass.isFrozen()) {
			ctClass.defrost();
		}
		return modifiedClass;
	}
	
	private CtMethod findMethod(CtClass ctClass, Patch patch) throws NotFoundException {
		Collection<CtMethod> methods = new ArrayList<>();
		for (CtMethod method : ctClass.getDeclaredMethods()) {
			if (method.getName().equals(patch.getPatchMethod())) {
				methods.add(method);
			}
		}

		for (CtMethod method : methods) {
			CtClass[] paramTypes = method.getParameterTypes();
			if (!isRightMethod(paramTypes, patch.getPatchParams())) {
				continue;
			}
			return method;
		}
		
		throw new NotFoundException("Cannot find right method.");
	}

	private boolean isRightMethod(CtClass[] paramTypes, String[] methodParameters) {
		for (int i = 0; i < paramTypes.length; ++i) {
			if (!methodParameters[i].equals(paramTypes[i].getName())) {
				return false;
			}
		}
		return true;
	}
	
	private void injectPatchedClasses() {
		Main.LOGGER.info("Injecting patched classes...");
		if (!FileUtils.copyGameFile()) {
			success = false;
			return;
		}
		
		for (Entry<String, byte[]> patch : patchedClasses.entrySet()) {
			try {
				applyPatch(patch.getKey(), patch.getValue());
			} catch (Exception e) {
				Main.LOGGER.error("Error when applying patch.", e);
				success = false;
				return;
			}
		}
	}
	
	private void applyPatch(String patchedClass, byte[] patchedClassData) throws Exception {
		Main.LOGGER.info("Applying patch for class: " + patchedClass);
		File patchFile = new File(patchedClass);
		File patchDir = patchFile.getParentFile();

		if (!patchDir.exists()) {
			patchDir.mkdirs();
		}

		if (!patchFile.exists()) {
			patchFile.createNewFile();
		}

		FileOutputStream stream = new FileOutputStream(patchFile);
		stream.write(patchedClassData);
		stream.flush();
		stream.close();

		Main.LOGGER.info("Patch file created for: " + patchedClass + ". Starting injection...");
		
		if (!JarUtils.injectToJar(new File(FileUtils.TMPFILENAME), Paths.get(patchedClass).toString())) {
			success = false;
		}

		Main.LOGGER.info("Removing patch file...");
		FileUtils.clear(patchDir);
		Main.LOGGER.info("Patch applied.");
	}
}
