package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PVPKillBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PVPKill extends AbstractJournalEvent<PVPKillBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PVPKillBean.class;
	}
	
	protected void processBean(PVPKillBean bean) {
	}

}
	