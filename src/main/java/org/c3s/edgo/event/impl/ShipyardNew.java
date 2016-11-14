package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardNewBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardNew extends AbstractJournalEvent<ShipyardNewBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ShipyardNewBean.class;
	}
	
	protected void processBean(ShipyardNewBean bean) {
	}

}
	