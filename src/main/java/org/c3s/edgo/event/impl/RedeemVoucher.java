package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;
import java.sql.Timestamp;

import org.c3s.edgo.common.access.DbAccess;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.beans.DBStationHistoryBean;
import org.c3s.edgo.common.dao.MissionsDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RedeemVoucherBean;
import org.c3s.edgo.event.impl.beans.intl.FactionAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedeemVoucher extends AbstractJournalEvent<RedeemVoucherBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RedeemVoucherBean.class;
	}
	
	protected void processBean(RedeemVoucherBean bean) {
		
		try {
			//DBMaterialsBean mat = MissionsDAO.getMaterial(bean.getName(), bean.getCategory());
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				
				DBStationHistoryBean station = DbAccess.stationHistoryAccess.getLastStation(pilot.getPilotId(), new Timestamp(bean.getTimestamp().getTime()));
				if (station != null) {
					if (bean.getFactions() != null && bean.getFactions().length > 0) {
						for(FactionAmount fa: bean.getFactions()) {
							MissionsDAO.insertBounty(pilot, station, bean.getTimestamp(), fa.getFaction(), bean.getType(), fa.getAmount(), bean.getBrokerPercenentage());
						}
					} else if (bean.getFaction() != null) {
						MissionsDAO.insertBounty(pilot, station, bean.getTimestamp(), bean.getFaction(), bean.getType(), bean.getAmount(), bean.getBrokerPercenentage());
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	