package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MassModuleStoreBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MassModuleStore extends AbstractJournalEvent<MassModuleStoreBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MassModuleStoreBean.class;
	}
	
	protected void processBean(MassModuleStoreBean bean) {
	}

}
	