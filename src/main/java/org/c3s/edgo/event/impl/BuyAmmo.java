package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.BuyAmmoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyAmmo extends AbstractJournalEvent<BuyAmmoBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = BuyAmmoBean.class;
	}
	
	protected void processBean(BuyAmmoBean bean) {
	}

}
	