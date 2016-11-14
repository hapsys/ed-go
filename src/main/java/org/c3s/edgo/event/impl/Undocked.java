package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.UndockedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Undocked extends AbstractJournalEvent<UndockedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = UndockedBean.class;
	}
	
	protected void processBean(UndockedBean bean) {
	}

}
	