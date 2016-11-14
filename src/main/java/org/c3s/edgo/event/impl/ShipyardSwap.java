package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardSwapBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardSwap extends AbstractJournalEvent<ShipyardSwapBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ShipyardSwapBean.class;
	}
	
	protected void processBean(ShipyardSwapBean bean) {
	}

}
	