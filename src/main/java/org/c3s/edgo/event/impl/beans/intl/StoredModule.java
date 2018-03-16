package org.c3s.edgo.event.impl.beans.intl;

import java.math.BigInteger;

public class StoredModule {

	String Name;
	
	String StarSystem;
	
	Integer StorageSlot;
	
	BigInteger MarketID;
	
	Long TransferCost;
	
	Long TransferTime;
	
	Long BuyPrice;
	
	Boolean Hot;
	
	String EngineerModifications;
	
	Integer Level;
	
	Float Quality;
	
	Boolean InTransit;

	String strHash;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getStarSystem() {
		return StarSystem;
	}

	public void setStarSystem(String starSystem) {
		StarSystem = starSystem;
	}

	public Integer getStorageSlot() {
		return StorageSlot;
	}

	public void setStorageSlot(Integer storageSlot) {
		StorageSlot = storageSlot;
	}

	public BigInteger getMarketID() {
		return MarketID;
	}

	public void setMarketID(BigInteger marketID) {
		MarketID = marketID;
	}

	public Long getTransferCost() {
		return TransferCost;
	}

	public void setTransferCost(Long transferCost) {
		TransferCost = transferCost;
	}

	public Long getTransferTime() {
		return TransferTime;
	}

	public void setTransferTime(Long transferTime) {
		TransferTime = transferTime;
	}

	public Long getBuyPrice() {
		return BuyPrice;
	}

	public void setBuyPrice(Long buyPrice) {
		BuyPrice = buyPrice;
	}

	public Boolean getHot() {
		return Hot;
	}

	public void setHot(Boolean hot) {
		Hot = hot;
	}

	public String getEngineerModifications() {
		return EngineerModifications;
	}

	public void setEngineerModifications(String engineerModifications) {
		EngineerModifications = engineerModifications;
	}

	public Integer getLevel() {
		return Level;
	}

	public void setLevel(Integer level) {
		Level = level;
	}

	public Float getQuality() {
		return Quality;
	}

	public void setQuality(Float quality) {
		Quality = quality;
	}

	public Boolean getInTransit() {
		return InTransit;
	}

	public void setInTransit(Boolean inTransit) {
		InTransit = inTransit;
	}

	public String getStrHash() {
		return strHash;
	}

	public void setStrHash(String strHash) {
		this.strHash = strHash;
	}
}
