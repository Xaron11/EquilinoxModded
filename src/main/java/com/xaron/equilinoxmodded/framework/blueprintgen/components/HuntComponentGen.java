package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;


import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.GameRepository.Classification;


public class HuntComponentGen extends ComponentGen {

	private int range;
	private Classification[] preyClassifications;
	private boolean huntsYoung;
	private boolean huntsOld;
	
	public HuntComponentGen(int range, Classification[] preyClassifications, boolean huntsYoung, boolean huntOld) {
		super("HUNT");
		this.range = range;
		this.preyClassifications = preyClassifications;
		this.huntsYoung = huntsYoung;
		this.huntsOld = huntOld;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		writer.writeLabelInt("range", range);
		writer.writeLabelInt("preyCount", preyClassifications.length);
		for (int i = 0; i < preyClassifications.length; i++) {
			writer.writeLabelString("prey", preyClassifications[i].get());
		}
		writer.writeLabelBool("huntsYoung", huntsYoung);
		writer.writeLabelBool("huntsOld", huntsOld);
	}

}
