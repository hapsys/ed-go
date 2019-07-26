package org.c3s.edgo.event.impl.beans.intl;

import java.math.BigInteger;

public class StoredShipsRemote {

	private int ShipID; 
	
	private String StarSystem;
	
	private BigInteger ShipMarketID;
	
	private String ShipType;
	
	private String ShipType_Localised;
	
	private String Name;
	
	private int TransferPrice;
	
	private int TransferTime;
	
	private BigInteger Value;
	
	private boolean Hot;
	
	private boolean InTransit;

	public int getShipID() {
		return ShipID;
	}

	public void setShipID(int shipID) {
		ShipID = shipID;
	}

	public String getStarSystem() {
		return StarSystem;
	}

	public void setStarSystem(String starSystem) {
		StarSystem = starSystem;
	}

	public BigInteger getShipMarketID() {
		return ShipMarketID;
	}

	public void setShipMarketID(BigInteger shipMarketID) {
		ShipMarketID = shipMarketID;
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

	public int getTransferPrice() {
		return TransferPrice;
	}

	public void setTransferPrice(int transferPrice) {
		TransferPrice = transferPrice;
	}

	public int getTransferTime() {
		return TransferTime;
	}

	public void setTransferTime(int transferTime) {
		TransferTime = transferTime;
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

	public boolean isInTransit() {
		return InTransit;
	}

	public void setInTransit(boolean inTransit) {
		InTransit = inTransit;
	}
	
	
}
