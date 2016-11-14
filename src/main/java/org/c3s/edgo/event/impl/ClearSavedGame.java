package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ClearSavedGameBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClearSavedGame extends AbstractJournalEvent<ClearSavedGameBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ClearSavedGameBean.class;
	}
	
	protected void processBean(ClearSavedGameBean bean) {
	}

}
	