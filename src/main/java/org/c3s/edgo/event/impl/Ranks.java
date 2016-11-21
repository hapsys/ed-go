package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RanksBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ranks extends AbstractJournalEvent<RanksBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RanksBean.class;
	}
	
	protected void processBean(RanksBean bean) {
	}

}
	