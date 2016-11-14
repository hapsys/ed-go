package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MarketSellBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarketSell extends AbstractJournalEvent<MarketSellBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MarketSellBean.class;
	}
	
	protected void processBean(MarketSellBean bean) {
	}

}
	