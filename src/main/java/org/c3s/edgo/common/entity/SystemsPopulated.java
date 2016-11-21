package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the systems_populated database table.
 * 
 */
@Entity
@Table(name="systems_populated")
@NamedQuery(name="SystemsPopulated.findAll", query="SELECT s FROM SystemsPopulated s")
public class SystemsPopulated implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="system_id")
	private String systemId;

	private String allegiance;

	@Column(name="allegiance_id")
	private int allegianceId;

	private String government;

	@Column(name="government_id")
	private int governmentId;

	private String name;

	@Column(name="name_uniq")
	private String nameUniq;

	@Column(name="needs_permit")
	private byte needsPermit;

	private BigInteger population;

	@Column(name="power_id")
	private int powerId;

	@Column(name="power_state")
	private String powerState;

	@Column(name="power_state_id")
	private int powerStateId;

	@Column(name="primary_economy")
	private String primaryEconomy;

	@Column(name="primary_economy_id")
	private int primaryEconomyId;

	@Column(name="reserve_type")
	private String reserveType;

	@Column(name="reserve_type_id")
	private int reserveTypeId;

	private String security;

	@Column(name="security_id")
	private int securityId;

	private String state;

	@Column(name="state_id")
	private int stateId;

	@Column(name="updated_at")
	private int updatedAt;

	private BigDecimal x;

	private BigDecimal y;

	private BigDecimal z;

	public SystemsPopulated() {
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getAllegiance() {
		return this.allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public int getAllegianceId() {
		return this.allegianceId;
	}

	public void setAllegianceId(int allegianceId) {
		this.allegianceId = allegianceId;
	}

	public String getGovernment() {
		return this.government;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	public int getGovernmentId() {
		return this.governmentId;
	}

	public void setGovernmentId(int governmentId) {
		this.governmentId = governmentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameUniq() {
		return this.nameUniq;
	}

	public void setNameUniq(String nameUniq) {
		this.nameUniq = nameUniq;
	}

	public byte getNeedsPermit() {
		return this.needsPermit;
	}

	public void setNeedsPermit(byte needsPermit) {
		this.needsPermit = needsPermit;
	}

	public BigInteger getPopulation() {
		return this.population;
	}

	public void setPopulation(BigInteger population) {
		this.population = population;
	}

	public int getPowerId() {
		return this.powerId;
	}

	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}

	public String getPowerState() {
		return this.powerState;
	}

	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

	public int getPowerStateId() {
		return this.powerStateId;
	}

	public void setPowerStateId(int powerStateId) {
		this.powerStateId = powerStateId;
	}

	public String getPrimaryEconomy() {
		return this.primaryEconomy;
	}

	public void setPrimaryEconomy(String primaryEconomy) {
		this.primaryEconomy = primaryEconomy;
	}

	public int getPrimaryEconomyId() {
		return this.primaryEconomyId;
	}

	public void setPrimaryEconomyId(int primaryEconomyId) {
		this.primaryEconomyId = primaryEconomyId;
	}

	public String getReserveType() {
		return this.reserveType;
	}

	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}

	public int getReserveTypeId() {
		return this.reserveTypeId;
	}

	public void setReserveTypeId(int reserveTypeId) {
		this.reserveTypeId = reserveTypeId;
	}

	public String getSecurity() {
		return this.security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public int getSecurityId() {
		return this.securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}

	public BigDecimal getX() {
		return this.x;
	}

	public void setX(BigDecimal x) {
		this.x = x;
	}

	public BigDecimal getY() {
		return this.y;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

	public BigDecimal getZ() {
		return this.z;
	}

	public void setZ(BigDecimal z) {
		this.z = z;
	}

}