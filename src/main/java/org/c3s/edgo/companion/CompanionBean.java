package org.c3s.edgo.companion;

import java.util.HashMap;

public class CompanionBean {

	public Commander commander;
	public System lastSystem;
	public StarPort lastStaport;
	public Ship ship;
	public HashMap<String, Ship> ships = new HashMap<String, Ship>(); 

	
}
