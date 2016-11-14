package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EscapeInterdictionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EscapeInterdiction extends AbstractJournalEvent<EscapeInterdictionBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = EscapeInterdictionBean.class;
	}
	
	protected void processBean(EscapeInterdictionBean bean) {
	}

}
	