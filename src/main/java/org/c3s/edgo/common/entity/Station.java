package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stations database table.
 * 
 */
@Entity
@Table(name="stations")
@NamedQueries({
	@NamedQuery(name="Station.findAll", query="SELECT s FROM Station s"),
	@NamedQuery(name="Station.findByUniq", query="SELECT s FROM Station s WHERE s.nameUniq = :uniq"),
})
public class Station implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="station_id")
	private int stationId;

	private String allegiance;

	@Column(name="body_id")
	private Integer bodyId;

	@Column(name="distance_to_star")
	private Integer distanceToStar;

	@Lob
	private String economies;

	@Column(name="faction_id")
	private Integer factionId;

	private String government;

	@Column(name="has_blackmarket")
	private byte hasBlackmarket;

	@Column(name="has_commodities")
	private byte hasCommodities;

	@Column(name="has_docking")
	private byte hasDocking;

	@Column(name="has_market")
	private byte hasMarket;

	@Column(name="has_outfitting")
	private byte hasOutfitting;

	@Column(name="has_rearm")
	private byte hasRearm;

	@Column(name="has_refuel")
	private byte hasRefuel;

	@Column(name="has_repair")
	private byte hasRepair;

	@Column(name="has_shipyard")
	private byte hasShipyard;

	@Column(name="is_planetary")
	private byte isPlanetary;

	@Column(name="max_landing_pad_size")
	private String maxLandingPadSize;

	private String name;

	@Column(name="name_uniq")
	private String nameUniq;

	@Column(name="settlement_security")
	private String settlementSecurity;

	@Column(name="settlement_security_id")
	private Integer settlementSecurityId;

	@Column(name="settlement_size")
	private String settlementSize;

	@Column(name="settlement_size_id")
	private Integer settlementSizeId;

	private String state;

	@Column(name="system_id")
	private int systemId;

	private String type;

	@Column(name="type_id")
	private Integer typeId;

	@Column(name="updated_at")
	private int updatedAt;

	public Station() {
	}

	public int getStationId() {
		return this.stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getAllegiance() {
		return this.allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public int getBodyId() {
		return this.bodyId;
	}

	public void setBodyId(int bodyId) {
		this.bodyId = bodyId;
	}

	public int getDistanceToStar() {
		return this.distanceToStar;
	}

	public void setDistanceToStar(int distanceToStar) {
		this.distanceToStar = distanceToStar;
	}

	public String getEconomies() {
		return this.economies;
	}

	public void setEconomies(String economies) {
		this.economies = economies;
	}

	public int getFactionId() {
		return this.factionId;
	}

	public void setFactionId(int factionId) {
		this.factionId = factionId;
	}

	public String getGovernment() {
		return this.government;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	public byte getHasBlackmarket() {
		return this.hasBlackmarket;
	}

	public void setHasBlackmarket(byte hasBlackmarket) {
		this.hasBlackmarket = hasBlackmarket;
	}

	public byte getHasCommodities() {
		return this.hasCommodities;
	}

	public void setHasCommodities(byte hasCommodities) {
		this.hasCommodities = hasCommodities;
	}

	public byte getHasDocking() {
		return this.hasDocking;
	}

	public void setHasDocking(byte hasDocking) {
		this.hasDocking = hasDocking;
	}

	public byte getHasMarket() {
		return this.hasMarket;
	}

	public void setHasMarket(byte hasMarket) {
		this.hasMarket = hasMarket;
	}

	public byte getHasOutfitting() {
		return this.hasOutfitting;
	}

	public void setHasOutfitting(byte hasOutfitting) {
		this.hasOutfitting = hasOutfitting;
	}

	public byte getHasRearm() {
		return this.hasRearm;
	}

	public void setHasRearm(byte hasRearm) {
		this.hasRearm = hasRearm;
	}

	public byte getHasRefuel() {
		return this.hasRefuel;
	}

	public void setHasRefuel(byte hasRefuel) {
		this.hasRefuel = hasRefuel;
	}

	public byte getHasRepair() {
		return this.hasRepair;
	}

	public void setHasRepair(byte hasRepair) {
		this.hasRepair = hasRepair;
	}

	public byte getHasShipyard() {
		return this.hasShipyard;
	}

	public void setHasShipyard(byte hasShipyard) {
		this.hasShipyard = hasShipyard;
	}

	public byte getIsPlanetary() {
		return this.isPlanetary;
	}

	public void setIsPlanetary(byte isPlanetary) {
		this.isPlanetary = isPlanetary;
	}

	public String getMaxLandingPadSize() {
		return this.maxLandingPadSize;
	}

	public void setMaxLandingPadSize(String maxLandingPadSize) {
		this.maxLandingPadSize = maxLandingPadSize;
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

	public String getSettlementSecurity() {
		return this.settlementSecurity;
	}

	public void setSettlementSecurity(String settlementSecurity) {
		this.settlementSecurity = settlementSecurity;
	}

	public int getSettlementSecurityId() {
		return this.settlementSecurityId;
	}

	public void setSettlementSecurityId(int settlementSecurityId) {
		this.settlementSecurityId = settlementSecurityId;
	}

	public String getSettlementSize() {
		return this.settlementSize;
	}

	public void setSettlementSize(String settlementSize) {
		this.settlementSize = settlementSize;
	}

	public int getSettlementSizeId() {
		return this.settlementSizeId;
	}

	public void setSettlementSizeId(int settlementSizeId) {
		this.settlementSizeId = settlementSizeId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSystemId() {
		return this.systemId;
	}

	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}

}