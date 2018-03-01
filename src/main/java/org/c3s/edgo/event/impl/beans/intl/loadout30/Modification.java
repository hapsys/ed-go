package org.c3s.edgo.event.impl.beans.intl.loadout30;

public class Modification {

	private String Label;

	private float Value;

	private float OriginalValue;
	
	private int LessIsGood;

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public float getValue() {
		return Value;
	}

	public void setValue(float value) {
		Value = value;
	}

	public float getOriginalValue() {
		return OriginalValue;
	}

	public void setOriginalValue(float originalValue) {
		OriginalValue = originalValue;
	}

	public int getLessIsGood() {
		return LessIsGood;
	}

	public void setLessIsGood(int lessIsGood) {
		LessIsGood = lessIsGood;
	}
}
