package com.xaron.equilinoxmodded.framework.blueprintgen;

import java.io.IOException;

import com.xaron.equilinoxmodded.framework.blueprintgen.components.ComponentGen;

public abstract class BlueprintGen {
	
	protected float size = 1.0f;
	protected int overrideName = -1;
	protected int overrideMainModelIndex = -1;
	protected boolean randomizeModelStages = false;
	protected boolean alwaysVisible = false;
	protected String classification = "eo";
	protected boolean underwater = false;
	protected boolean overwater = true;
	protected float acceptableHeightOffset = 0.0f;

	protected abstract SubBlueprintGen[] getSubBlueprints() throws IOException;

	protected abstract ComponentGen[] getComponents();
}
