package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PromotionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Promotion extends AbstractJournalEvent<PromotionBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PromotionBean.class;
	}
	
	protected void processBean(PromotionBean bean) {
	}

}
	