package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardSellBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardSell extends AbstractJournalEvent<ShipyardSellBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ShipyardSellBean.class;
	}
	
	protected void processBean(ShipyardSellBean bean) {
	}

}
	