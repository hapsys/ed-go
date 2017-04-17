package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ScannedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scanned extends AbstractJournalEvent<ScannedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Scanned.class);
	
	{
		beanClass = ScannedBean.class;
	}
	
	protected void processBean(ScannedBean bean) {
	}

}
	