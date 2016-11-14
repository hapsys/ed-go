package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ShipyardTransferBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShipyardTransfer extends AbstractJournalEvent<ShipyardTransferBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ShipyardTransferBean.class;
	}
	
	protected void processBean(ShipyardTransferBean bean) {
	}

}
	