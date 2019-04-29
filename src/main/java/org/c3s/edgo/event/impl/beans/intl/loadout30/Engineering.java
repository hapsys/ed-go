package org.c3s.edgo.event.impl.beans.intl.loadout30;

import java.math.BigInteger;

public class Engineering {

	private BigInteger EngineerID;
	
	private String Engineer;
	
	private BigInteger BlueprintID;
	
	private String BlueprintName;
	
	private int Level;
	
	private float Quality;
	
	private String ExperimentalEffect;
	
	private String ExperimentalEffect_Localised;
	
	//private Modification[] Modifiers;
	private Modification[] Modifiers;

	public BigInteger getEngineerID() {
		return EngineerID;
	}

	public void setEngineerID(BigInteger engineerID) {
		EngineerID = engineerID;
	}

	public String getEngineer() {
		return Engineer;
	}

	public void setEngineer(String engineer) {
		Engineer = engineer;
	}

	public BigInteger getBlueprintID() {
		return BlueprintID;
	}

	public void setBlueprintID(BigInteger blueprintID) {
		BlueprintID = blueprintID;
	}

	public String getBlueprintName() {
		return BlueprintName;
	}

	public void setBlueprintName(String blueprintName) {
		BlueprintName = blueprintName;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public float getQuality() {
		return Quality;
	}

	public void setQuality(float quality) {
		Quality = quality;
	}

	public String getExperimentalEffect() {
		return ExperimentalEffect;
	}

	public void setExperimentalEffect(String experimentalEffect) {
		ExperimentalEffect = experimentalEffect;
	}

	public String getExperimentalEffect_Localised() {
		return ExperimentalEffect_Localised;
	}

	public void setExperimentalEffect_Localised(String experimentalEffect_Localised) {
		ExperimentalEffect_Localised = experimentalEffect_Localised;
	}

	public Modification[] getModifiers() {
		return Modifiers;
	}

	public void setModifiers(Modification[] modifiers) {
		Modifiers = modifiers;
	}
	
	
}
