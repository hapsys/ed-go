package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CapShipBondBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapShipBond extends AbstractJournalEvent<CapShipBondBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CapShipBondBean.class;
	}
	
	protected void processBean(CapShipBondBean bean) {
	}

}
	