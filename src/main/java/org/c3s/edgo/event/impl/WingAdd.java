package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.WingAddBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WingAdd extends AbstractJournalEvent<WingAddBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = WingAddBean.class;
	}
	
	protected void processBean(WingAddBean bean) {
	}

}
	