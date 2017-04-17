package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.QuitACrewBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuitACrew extends AbstractJournalEvent<QuitACrewBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(QuitACrew.class);
	
	{
		beanClass = QuitACrewBean.class;
	}
	
	protected void processBean(QuitACrewBean bean) {
	}

}
	