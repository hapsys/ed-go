package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LaunchFighterBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaunchFighter extends AbstractJournalEvent<LaunchFighterBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = LaunchFighterBean.class;
	}
	
	protected void processBean(LaunchFighterBean bean) {
	}

}
	