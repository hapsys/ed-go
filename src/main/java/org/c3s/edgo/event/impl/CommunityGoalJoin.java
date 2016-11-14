package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CommunityGoalJoinBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunityGoalJoin extends AbstractJournalEvent<CommunityGoalJoinBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CommunityGoalJoinBean.class;
	}
	
	protected void processBean(CommunityGoalJoinBean bean) {
	}

}
	