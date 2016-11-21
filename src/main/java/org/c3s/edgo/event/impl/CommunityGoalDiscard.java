package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CommunityGoalDiscardBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunityGoalDiscard extends AbstractJournalEvent<CommunityGoalDiscardBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CommunityGoalDiscardBean.class;
	}
	
	protected void processBean(CommunityGoalDiscardBean bean) {
	}

}
	