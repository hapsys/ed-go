package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleSwapBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleSwap extends AbstractJournalEvent<ModuleSwapBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ModuleSwapBean.class;
	}
	
	protected void processBean(ModuleSwapBean bean) {
	}

}
	