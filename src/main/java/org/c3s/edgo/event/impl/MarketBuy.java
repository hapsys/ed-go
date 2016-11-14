package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MarketBuyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarketBuy extends AbstractJournalEvent<MarketBuyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MarketBuyBean.class;
	}
	
	protected void processBean(MarketBuyBean bean) {
	}

}
	