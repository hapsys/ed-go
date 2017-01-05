package org.c3s.edgo.common.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBLocationHistoryBean;
import org.c3s.edgo.common.beans.DBPilotDeliverBean;
import org.c3s.edgo.common.beans.DBPilotKillMeritsBean;
import org.c3s.edgo.common.beans.DBPilotPowerBean;
import org.c3s.edgo.common.beans.DBPilotPowerSpendBean;
import org.c3s.edgo.common.beans.DBPilotWarMeritsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBPowerStateBean;
import org.c3s.edgo.common.beans.DBPowerStateTypeBean;
import org.c3s.edgo.common.beans.DBPowersBean;
import org.c3s.edgo.common.beans.DBPrevWeekSystemStateSingleBean;
import org.c3s.edgo.common.beans.DBSystemsBean;
import org.c3s.edgo.utils.EDUtils;

public class PowersDAO {

	public static Date getStartWeek(Date current) {
		//Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		//Calendar newDate = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		Calendar calendar = Calendar.getInstance();
		Calendar newDate = Calendar.getInstance();
		
		calendar.setTime(current);
	
		//System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		int day = (calendar.get(Calendar.DAY_OF_WEEK) + 2) % 7;
		if (day == 0 && calendar.get(Calendar.HOUR_OF_DAY) < 7) {
			calendar.setTimeInMillis(current.getTime() - 7 * 24 * 3600 * 1000);
		} else if (day > 0) {
			calendar.setTimeInMillis(current.getTime() - day * 24 * 3600 * 1000);
		}
		newDate.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 7, 0, 0);
		newDate.setTimeInMillis(newDate.getTimeInMillis()/1000*1000);
		//System.out.println(day);
		
		return newDate.getTime();
	}
	
	public static DBPowerStateTypeBean getOrInsertState(String state) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBPowerStateTypeBean bean = null;
		if (state != null) {
			String uniq = EDUtils.cutFull(state);
			if ((bean = DbAccess.powerStateTypeAccess.getByUniq(uniq)) == null) {
				bean = new DBPowerStateTypeBean();
				bean.setPowerStateTypeName(state);
				bean.setPowerStateTypeUniq(uniq);
				bean.setIsWeekly(0);
				bean.setIsMerits(0);
				bean.setIsPermanent(0);
				DbAccess.powerStateTypeAccess.insert(bean);
			}
		}
		return bean;
	}
	
	public static DBPowersBean getPower(String power) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		String uniq = EDUtils.cutFull(power);
		return DbAccess.powersAccess.getByUniqOrAlias(uniq, uniq);
	}
	
	
	public static void updateOrInsertPowerState(String system, String[] powers, String state, Date timestamp) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		DBSystemsBean sys = SystemsDAO.getOrInsertSystem(system, null);
		if (sys != null && powers != null) {
			DBPowerStateTypeBean pstate = getOrInsertState(state);
			Date weekDate = getStartWeek(timestamp);
			Timestamp ts = new Timestamp(weekDate.getTime());
			if (DbAccess.powerStateAccess.getPrevWeekSystemStateCount(sys.getSystemId(), ts, ts).getCount() == 0) {
				for(String power: powers) {
					DBPowersBean pow = getPower(power);
					DBPowerStateBean bean =  new DBPowerStateBean();
					bean.setSystemId(sys.getSystemId());
					bean.setPowerId(pow.getPowerId());
					bean.setPowerStateTypeId(pstate.getPowerStateTypeId());
					if (pstate.getIsPermanent() == 0) {
						bean.setStartWeek(ts);
					}
					if (pstate.getIsWeekly() == 1) {
						bean.setEndWeek(new Timestamp(weekDate.getTime() + 7 * 24 * 3600 * 1000));
					}
					DbAccess.powerStateAccess.insert(bean);
				}
			}
		}
	}
	
	public static DBPilotPowerBean getOrInsertPilotPower(DBPilotsBean pilot, String powerStr, Date timestamp) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		
		Timestamp ts = new Timestamp(getStartWeek(timestamp).getTime());
		
		DBPilotPowerBean bean = null;
		
		
		DBPowersBean power = null;
		if (powerStr != null) {
			power = getPower(powerStr);
			//System.out.println(power);
		}
		
		DBPilotPowerBean prevPower = DbAccess.pilotPowerAccess.getLastByPilotId(pilot.getPilotId());
		
		bean = prevPower;
		
		if (prevPower != null && power != null) {
			if (!power.getPowerId().equals(prevPower.getPowerId())) {
				bean = new DBPilotPowerBean();
				bean.setPilotId(pilot.getPilotId());
				bean.setPowerId(power.getPowerId());
				bean.setPilotPowerTime(new Timestamp(timestamp.getTime()));
				DbAccess.pilotPowerAccess.insert(bean);
				DbAccess.pilotKillMeritsAccess.updateNulledByPilotIdAndTime(bean.getPilotPowerId(), pilot.getPilotId(), ts);
				DbAccess.pilotWarMeritsAccess.updateNulledByPilotIdAndTime(bean.getPilotPowerId(), pilot.getPilotId(), ts);
			}
		} else if (prevPower == null && power != null) {
			bean = new DBPilotPowerBean();
			bean.setPilotId(pilot.getPilotId());
			bean.setPowerId(power.getPowerId());
			bean.setPilotPowerTime(new Timestamp(timestamp.getTime()));
			DbAccess.pilotPowerAccess.insert(bean);
			DbAccess.pilotKillMeritsAccess.updateNulledByPilotIdAndTime(bean.getPilotPowerId(), pilot.getPilotId(), ts);
			DbAccess.pilotWarMeritsAccess.updateNulledByPilotIdAndTime(bean.getPilotPowerId(), pilot.getPilotId(), ts);
		} else if (prevPower != null && power == null) {
			bean = new DBPilotPowerBean();
			bean.setPilotId(pilot.getPilotId());
			bean.setPowerId(null);
			bean.setPilotPowerTime(new Timestamp(timestamp.getTime()));
			DbAccess.pilotPowerAccess.insert(bean);
			DbAccess.pilotKillMeritsAccess.updateNulledByPilotIdAndTime(bean.getPilotPowerId(), pilot.getPilotId(), ts);
			DbAccess.pilotWarMeritsAccess.updateNulledByPilotIdAndTime(bean.getPilotPowerId(), pilot.getPilotId(), ts);
		}
		return bean;
	}
	
	public static void updateFastTrack(DBPilotsBean pilot, Date timestamp, int count, Long pilotPowerId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		Timestamp startWeek = new Timestamp(getStartWeek(timestamp).getTime());
		DBPilotPowerSpendBean bean = DbAccess.pilotPowerSpendAccess.getByPilotIdAndWeek(pilot.getPilotId(), startWeek);
		if (bean == null) {
			bean = new DBPilotPowerSpendBean();
			bean.setPilotId(pilot.getPilotId());
			bean.setStartWeek(startWeek);
			bean.setQuantity(Long.valueOf(count));
			DbAccess.pilotPowerSpendAccess.insert(bean);
		} else {
			bean.setQuantity(bean.getQuantity() + count);
			DbAccess.pilotPowerSpendAccess.updateByPrimaryKey(bean,bean.getPilotPowerSpendId());
		}
	}
	
	public static void updateDeliver(DBPilotsBean pilot, Date timestamp, int count, Long pilotPowerId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		Timestamp startWeek = new Timestamp(getStartWeek(timestamp).getTime());
		DBLocationHistoryBean location = DbAccess.locationHistoryAccess.getLastLocation(pilot.getPilotId());
		DBPilotDeliverBean bean = DbAccess.pilotDeliverAccess.getByPilotIdAndSystemIdAndWeek(pilot.getPilotId(), location.getSystemId(), startWeek);
		if (bean == null) {
			bean = new DBPilotDeliverBean();
			bean.setPilotId(pilot.getPilotId());
			bean.setSystemId(location.getSystemId());
			bean.setStartWeek(startWeek);
			bean.setQuantity(Long.valueOf(count));
			DbAccess.pilotDeliverAccess.insert(bean);
		} else {
			bean.setQuantity(bean.getQuantity() + count);
			DbAccess.pilotDeliverAccess.updateByPrimaryKey(bean, bean.getPilotDeliverId());
		}
	}
	
	public static void updateCombatMerits(DBPilotsBean pilot, Date timestamp, Long pilotPowerId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		Timestamp startWeek = new Timestamp(getStartWeek(timestamp).getTime());
		DBLocationHistoryBean location = DbAccess.locationHistoryAccess.getLastLocation(pilot.getPilotId());
		DBPrevWeekSystemStateSingleBean state = DbAccess.powerStateAccess.getPrevWeekSystemStateSingle(location.getSystemId(), startWeek, startWeek);
		//System.out.println("+++" + DbAccess.systemsAccess.getByPrimaryKey(location.getSystemId()).getName());
		//System.out.println(startWeek.toString());
		if (state != null) {
			if (state.getIsWarzone().equals(1)) {
				DBPilotWarMeritsBean bean = DbAccess.pilotWarMeritsAccess.getNotConfirmedByPilotIdAndSystemIdAndWeek(pilot.getPilotId(), location.getSystemId(), startWeek);
				if (bean == null) {
					bean = new DBPilotWarMeritsBean();
					bean.setPilotId(pilot.getPilotId());
					bean.setSystemId(location.getSystemId());
					bean.setStartWeek(startWeek);
					bean.setQuantity(1L);
					bean.setIsConfirmed(0);
					bean.setPilotPowerId(pilotPowerId);
					DbAccess.pilotWarMeritsAccess.insert(bean);
				} else {
					bean.setQuantity(bean.getQuantity() + 1L);
					DbAccess.pilotWarMeritsAccess.updateByPrimaryKey(bean, bean.getPilotWarMeritsId());
				}
			} else 	if (state.getIsMerits().equals(1)) {
				DBPilotKillMeritsBean bean = DbAccess.pilotKillMeritsAccess.getNotConfirmedByPilotIdAndSystemIdAndWeek(pilot.getPilotId(), location.getSystemId(), startWeek);
				if (bean == null) {
					bean = new DBPilotKillMeritsBean();
					bean.setPilotId(pilot.getPilotId());
					bean.setSystemId(location.getSystemId());
					bean.setStartWeek(startWeek);
					bean.setQuantity(1L);
					bean.setIsConfirmed(0);
					bean.setPilotPowerId(pilotPowerId);
					DbAccess.pilotKillMeritsAccess.insert(bean);
				} else {
					bean.setQuantity(bean.getQuantity() + 1L);
					DbAccess.pilotKillMeritsAccess.updateByPrimaryKey(bean, bean.getPilotKillMeritsId());
				}
	
			}
		}
	}
	
	public static void updateConfirmedCombatMerits(DBPilotsBean pilot, String[] systems, Date timestamp) throws IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
		Timestamp startWeek = new Timestamp(getStartWeek(timestamp).getTime());
		if (systems != null) {
			for (String sys: systems) {
				//System.out.println(sys);
				String uniq = EDUtils.getSystemUniq(sys);
				DBSystemsBean system =  DbAccess.systemsAccess.getByUniq(uniq);
				if (system !=  null) {
					//System.out.println(">>>>" + system.getSystemId());
					//System.out.println(">>>>" + system.getName());
					//
					DBPilotWarMeritsBean warBean = DbAccess.pilotWarMeritsAccess.getNotConfirmedByPilotIdAndSystemIdAndWeek(pilot.getPilotId(), system.getSystemId(), startWeek);
					if (warBean != null) {
						DBPilotWarMeritsBean bean = DbAccess.pilotWarMeritsAccess.getConfirmedByPilotIdAndSystemIdAndWeek(pilot.getPilotId(), system.getSystemId(), startWeek);
						if (bean == null) {
							bean = new DBPilotWarMeritsBean();
							bean.setPilotId(pilot.getPilotId());
							bean.setSystemId(system.getSystemId());
							bean.setStartWeek(startWeek);
							bean.setQuantity(warBean.getQuantity());
							bean.setPilotPowerId(warBean.getPilotPowerId());
							bean.setIsConfirmed(1);
							DbAccess.pilotWarMeritsAccess.insert(bean);
						} else {
							bean.setQuantity(bean.getQuantity() + warBean.getQuantity());
							DbAccess.pilotWarMeritsAccess.updateByPrimaryKey(bean, bean.getPilotWarMeritsId());
						}
						DbAccess.pilotWarMeritsAccess.deleteByPrimaryKey(warBean.getPilotWarMeritsId());
					}
					//
					DBPilotKillMeritsBean killBean = DbAccess.pilotKillMeritsAccess.getNotConfirmedByPilotIdAndSystemIdAndWeek(pilot.getPilotId(), system.getSystemId(), startWeek);
					if (killBean != null) {
						DBPilotKillMeritsBean bean = DbAccess.pilotKillMeritsAccess.getConfirmedByPilotIdAndSystemIdAndWeek(pilot.getPilotId(), system.getSystemId(), startWeek);
						if (bean == null) {
							bean = new DBPilotKillMeritsBean();
							bean.setPilotId(pilot.getPilotId());
							bean.setSystemId(system.getSystemId());
							bean.setStartWeek(startWeek);
							bean.setQuantity(killBean.getQuantity());
							bean.setPilotPowerId(killBean.getPilotPowerId());
							bean.setIsConfirmed(1);
							DbAccess.pilotKillMeritsAccess.insert(bean);
						} else {
							bean.setQuantity(bean.getQuantity() + killBean.getQuantity());
							DbAccess.pilotKillMeritsAccess.updateByPrimaryKey(bean, bean.getPilotKillMeritsId());
						}
						DbAccess.pilotKillMeritsAccess.deleteByPrimaryKey(killBean.getPilotKillMeritsId());
					}
				}
			}
		}
	}
}
