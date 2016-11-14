package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleRetrieveBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRetrieve extends AbstractJournalEvent<ModuleRetrieveBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ModuleRetrieveBean.class;
	}
	
	protected void processBean(ModuleRetrieveBean bean) {
	}

}
	