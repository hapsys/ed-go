package org.c3s.edgo.common.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBBountyFactionBean;
import org.c3s.edgo.common.beans.DBBountyTypesBean;
import org.c3s.edgo.common.beans.DBCommoditiesBean;
import org.c3s.edgo.common.beans.DBFactionsBean;
import org.c3s.edgo.common.beans.DBMaterialCategoryBean;
import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBMissionTypesBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBRewardCommoditiesBean;
import org.c3s.edgo.common.beans.DBRewardMaterialsBean;
import org.c3s.edgo.utils.EDUtils;

public class MissionsDAO {

	public static DBMissionTypesBean getOrInsertMissionType(String type) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		String uniq = EDUtils.cutFull(type);
		
		DBMissionTypesBean bean = DbAccess.missionTypesAccess.getByUniq(uniq);
		if (bean ==  null) {
			bean = new DBMissionTypesBean();
			bean.setMissionTypeName(type);
			bean.setMissionTypeUniq(uniq);
			DbAccess.missionTypesAccess.insert(bean);
		}
		
		return bean;
	}
	
	public static DBCommoditiesBean getComodity(String name) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		String uniq = EDUtils.cutFull(name);
		DBCommoditiesBean bean = DbAccess.commoditiesAccess.getByUniq(uniq); 
		return bean;
	}
	
	public static void insertUpdateMissionComodity(BigInteger mission_id, long comodity_id, long count) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBRewardCommoditiesBean bean = DbAccess.rewardCommoditiesAccess.getByPrimaryKey(mission_id, comodity_id);
		if (bean == null) {
			bean = new DBRewardCommoditiesBean();
			bean.setMissionId(mission_id);
			bean.setCommodityId(comodity_id);
			bean.setQuantity(count);
			DbAccess.rewardCommoditiesAccess.insert(bean);
		} else {
			bean.setQuantity(count + bean.getQuantity());
			DbAccess.rewardCommoditiesAccess.updateByPrimaryKey(bean, mission_id, comodity_id);
		}
	}
	
	public static DBMaterialsBean getMaterial(String name, String type) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		String uniq = EDUtils.cutFull(name);
		DBMaterialsBean bean = DbAccess.materialsAccess.getByUniq(uniq);
		if (bean == null) {
			DBMaterialCategoryBean typeBean = DbAccess.materialCategoryAccess.getByUniq(type);
			if (typeBean == null) {
				typeBean = new DBMaterialCategoryBean();
				typeBean.setMaterialCategoryName(type);
				DbAccess.materialCategoryAccess.insert(typeBean);
			}
			bean = new DBMaterialsBean();
			bean.setMaterialUniq(uniq);
			bean.setMatherialCategoryId(typeBean.getMaterialCategoryId());
			DbAccess.materialsAccess.insert(bean);
		}
		return bean;
	}

	public static void insertUpdateMissionMaterial(BigInteger mission_id, long material_id, long count) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBRewardMaterialsBean bean = DbAccess.rewardMaterialsAccess.getByPrimaryKey(mission_id, material_id);
		if (bean == null) {
			bean = new DBRewardMaterialsBean();
			bean.setMissionId(mission_id);
			bean.setMaterialId(material_id);
			bean.setQuantity(count);
			DbAccess.rewardMaterialsAccess.insert(bean);
		} else {
			bean.setQuantity(count + bean.getQuantity());
			DbAccess.rewardMaterialsAccess.updateByPrimaryKey(bean, mission_id, material_id);
		}
	}
	
	/**
	 * 
	 */
	private static Map<String, DBBountyTypesBean> bountyTypes = new ConcurrentHashMap<>();
	
	public static DBBountyTypesBean getOrInsertBountyType(String bountyType) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBBountyTypesBean bean = null;
		if (bountyType != null) {
			String uniq = bountyType.toLowerCase();
			if (!bountyTypes.containsKey(uniq)) {
				bean = DbAccess.bountyTypesAccess.getByUniq(uniq);
				if (bean == null) {
					bean = new DBBountyTypesBean();
					bean.setBountyType(bountyType);
					bean.setBountyTypeUniq(uniq);
					DbAccess.bountyTypesAccess.insert(bean);
				}
				bountyTypes.put(uniq, bean);
			}
			bean = bountyTypes.get(uniq);
		}
		return bean;
	}
	
	public static void insertBounty(DBPilotsBean pilot, Date timestamp, String factionName, String bountyType, long amount, int brokerPerc) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBFactionsBean faction = SystemsDAO.getOrInsertFaction(factionName);
		
		DBBountyFactionBean bean = new DBBountyFactionBean();
		bean.setCreateDate(new Timestamp(timestamp.getTime()))
			.setBountyTypeId(getOrInsertBountyType(bountyType).getBountyTypeId())
			.setFactionId(faction.getFactionId())
			.setPilotId(pilot.getPilotId())
			.setAmount(amount)
			.setBrokerPercent(brokerPerc);
		DbAccess.bountyFactionAccess.insert(bean);
		
	}
}
