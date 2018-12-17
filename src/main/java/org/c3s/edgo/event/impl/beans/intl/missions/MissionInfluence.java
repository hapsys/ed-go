package org.c3s.edgo.event.impl.beans.intl.missions;

import java.math.BigInteger;

public class MissionInfluence {

	private BigInteger SystemAddress;
	
	private String Trend;

	private String Influence;

	public BigInteger getSystemAddress() {
		return SystemAddress;
	}

	public void setSystemAddress(BigInteger systemAddress) {
		SystemAddress = systemAddress;
	}

	public String getTrend() {
		return Trend;
	}

	public void setTrend(String trend) {
		Trend = trend;
	}

	public String getInfluence() {
		return Influence;
	}

	public void setInfluence(String influence) {
		Influence = influence;
	}
	
	
}
