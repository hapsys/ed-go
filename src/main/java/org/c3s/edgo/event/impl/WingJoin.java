package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.WingJoinBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WingJoin extends AbstractJournalEvent<WingJoinBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = WingJoinBean.class;
	}
	
	protected void processBean(WingJoinBean bean) {
	}

}
	