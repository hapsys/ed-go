package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ResurrectBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Resurrect extends AbstractJournalEvent<ResurrectBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ResurrectBean.class;
	}
	
	protected void processBean(ResurrectBean bean) {
	}

}
	