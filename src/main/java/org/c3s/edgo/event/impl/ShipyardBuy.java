package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardBuyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardBuy extends AbstractJournalEvent<ShipyardBuyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ShipyardBuyBean.class;
	}
	
	protected void processBean(ShipyardBuyBean bean) {
	}

}
	