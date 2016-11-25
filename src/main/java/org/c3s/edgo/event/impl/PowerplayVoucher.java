package org.c3s.edgo.event.impl;
	
import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.PowersDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayVoucherBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayVoucher extends AbstractJournalEvent<PowerplayVoucherBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PowerplayVoucher.class);
	
	{
		beanClass = PowerplayVoucherBean.class;
	}
	
	protected void processBean(PowerplayVoucherBean bean) {
		
		try {
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				PowersDAO.updateConfirmedCombatMerits(pilot, bean.getSystems(), bean.getTimestamp());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
	