package com.xaron.equilinoxmodded.framework.blueprintgen.components;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.CsvWriter;
import com.xaron.equilinoxmodded.framework.blueprintgen.components.deathai.DeathAIGen;


public class HealerComponentGen extends ComponentGen {

	private DeathAIGen deathAi;
	
	public HealerComponentGen(DeathAIGen deathAi) {
		super("HEALER");
		this.deathAi = deathAi;
	}
	
	@Override
	public void writeComponent(CsvWriter writer) throws IOException {
		super.writeComponent(writer);
		deathAi.write(writer);
	}

}
