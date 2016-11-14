package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.BountyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bounty extends AbstractJournalEvent<BountyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = BountyBean.class;
	}
	
	protected void processBean(BountyBean bean) {
	}

}
	