package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FetchRemoteModuleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchRemoteModule extends AbstractJournalEvent<FetchRemoteModuleBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = FetchRemoteModuleBean.class;
	}
	
	protected void processBean(FetchRemoteModuleBean bean) {
	}

}
	