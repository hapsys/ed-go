package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EngineerProgressBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineerProgress extends AbstractJournalEvent<EngineerProgressBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = EngineerProgressBean.class;
	}
	
	protected void processBean(EngineerProgressBean bean) {
	}

}
	