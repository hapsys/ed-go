package org.c3s.edgo.event.impl.beans.intl.loadout30;

public class Modification {

	private String Label;

	private Object Value;

	private Object OriginalValue;
	
	private int LessIsGood;

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public Object getValue() {
		return Value;
	}

	public void setValue(Object value) {
		Value = value;
	}

	public Object getOriginalValue() {
		return OriginalValue;
	}

	public void setOriginalValue(Object originalValue) {
		OriginalValue = originalValue;
	}

	public int getLessIsGood() {
		return LessIsGood;
	}

	public void setLessIsGood(int lessIsGood) {
		LessIsGood = lessIsGood;
	}
}
