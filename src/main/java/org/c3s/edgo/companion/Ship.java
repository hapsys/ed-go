package org.c3s.edgo.companion;

import java.util.HashMap;

public class Ship {

	public int id;
	public String name;
	
	public System starsystem;

	public StarPort station;
	
	public HashMap<String, SlotModule> modules = new HashMap<String, SlotModule>();
	
}
