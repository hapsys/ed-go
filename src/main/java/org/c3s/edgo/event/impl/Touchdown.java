package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.TouchdownBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Touchdown extends AbstractJournalEvent<TouchdownBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = TouchdownBean.class;
	}
	
	protected void processBean(TouchdownBean bean) {
	}

}
	