/**
 * 
 */
package org.c3s.edgo.event.impl.beans.intl;

/**
 * @author admin
 *
 */
public class LoadoutModule {

	private String Slot;
	private String Item;
	private Boolean On;
	private int Priority;
	private float Health;
	private int Value;
	
	private int AmmoInClip;
	private int AmmoInHopper;
	
	private String EngineerBlueprint;
	private int EngineerLevel;
	public String getSlot() {
		return Slot;
	}
	public void setSlot(String slot) {
		Slot = slot;
	}
	public String getItem() {
		return Item;
	}
	public void setItem(String item) {
		Item = item;
	}
	public Boolean getOn() {
		return On;
	}
	public void setOn(Boolean on) {
		On = on;
	}
	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}
	public float getHealth() {
		return Health;
	}
	public void setHealth(float health) {
		Health = health;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public int getAmmoInClip() {
		return AmmoInClip;
	}
	public void setAmmoInClip(int ammoInClip) {
		AmmoInClip = ammoInClip;
	}
	public int getAmmoInHopper() {
		return AmmoInHopper;
	}
	public void setAmmoInHopper(int ammoInHopper) {
		AmmoInHopper = ammoInHopper;
	}
	public String getEngineerBlueprint() {
		return EngineerBlueprint;
	}
	public void setEngineerBlueprint(String engineerBlueprint) {
		EngineerBlueprint = engineerBlueprint;
	}
	public int getEngineerLevel() {
		return EngineerLevel;
	}
	public void setEngineerLevel(int engineerLevel) {
		EngineerLevel = engineerLevel;
	}
	
	
}
