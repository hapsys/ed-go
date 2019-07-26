package org.c3s.edgo.event.impl.beans.intl;

import java.math.BigInteger;

public class StoredShipsHere {

	private int ShipID; 
	
	private String ShipType;
	
	private String ShipType_Localised;
	
	private String Name;
	
	private BigInteger Value;
	
	private boolean Hot;

	public int getShipID() {
		return ShipID;
	}

	public void setShipID(int shipID) {
		ShipID = shipID;
	}

	public String getShipType() {
		return ShipType;
	}

	public void setShipType(String shipType) {
		ShipType = shipType;
	}

	public String getShipType_Localised() {
		return ShipType_Localised;
	}

	public void setShipType_Localised(String shipType_Localised) {
		ShipType_Localised = shipType_Localised;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public BigInteger getValue() {
		return Value;
	}

	public void setValue(BigInteger value) {
		Value = value;
	}

	public boolean isHot() {
		return Hot;
	}

	public void setHot(boolean hot) {
		Hot = hot;
	}
	
	
}
