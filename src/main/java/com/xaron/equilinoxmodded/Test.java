package com.xaron.equilinoxmodded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		Process proc = Runtime.getRuntime().exec("java -jar \"EquilinoxWindows - Modded.jar\"");
		BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line;
		while ((line = input.readLine()) != null) {
		    System.out.println(line);
		}
		input.close();  
	}

}
