package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CommunityGoalRewardBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunityGoalReward extends AbstractJournalEvent<CommunityGoalRewardBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CommunityGoalRewardBean.class;
	}
	
	protected void processBean(CommunityGoalRewardBean bean) {
	}

}
	