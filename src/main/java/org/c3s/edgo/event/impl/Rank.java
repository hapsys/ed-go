package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RankBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rank extends AbstractJournalEvent<RankBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RankBean.class;
	}
	
	protected void processBean(RankBean bean) {
	}

}
	