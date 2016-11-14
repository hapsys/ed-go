package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EjectCargoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EjectCargo extends AbstractJournalEvent<EjectCargoBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = EjectCargoBean.class;
	}
	
	protected void processBean(EjectCargoBean bean) {
	}

}
	