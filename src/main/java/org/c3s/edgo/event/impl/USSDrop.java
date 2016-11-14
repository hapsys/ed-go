package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.USSDropBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USSDrop extends AbstractJournalEvent<USSDropBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = USSDropBean.class;
	}
	
	protected void processBean(USSDropBean bean) {
	}

}
	