package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ScanBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scan extends AbstractJournalEvent<ScanBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ScanBean.class;
	}
	
	protected void processBean(ScanBean bean) {
	}

}
	