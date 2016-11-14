package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleStoreBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleStore extends AbstractJournalEvent<ModuleStoreBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ModuleStoreBean.class;
	}
	
	protected void processBean(ModuleStoreBean bean) {
	}

}
	