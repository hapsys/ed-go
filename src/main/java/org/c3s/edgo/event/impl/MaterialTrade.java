package org.c3s.edgo.event.impl;

import java.sql.SQLException;

import org.c3s.edgo.common.beans.DBMaterialsBean;
import org.c3s.edgo.common.beans.DBPilotsBean;
import org.c3s.edgo.common.dao.MissionsDAO;
import org.c3s.edgo.common.dao.PilotDAO;
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MaterialTradeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaterialTrade extends AbstractJournalEvent<MaterialTradeBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(MaterialTrade.class);
	
	{
		beanClass = MaterialTradeBean.class;
	}
	
	protected void processBean(MaterialTradeBean bean) {
		try {
			
			DBMaterialsBean in = MissionsDAO.getMaterial(bean.getReceived().getMaterial(), bean.getTraderType());			
			DBMaterialsBean out = MissionsDAO.getMaterial(bean.getPaid().getMaterial(), bean.getTraderType());			
			
			DBPilotsBean pilot = getCurrent();
			if (pilot != null) {
				PilotDAO.insertUpdateMaterial(pilot.getPilotId(), in.getMaterialId(), bean.getReceived().getQuantity());
				PilotDAO.insertUpdateMaterial(pilot.getPilotId(), out.getMaterialId(), -bean.getReceived().getQuantity());
			}
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
