package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleSellBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleSell extends AbstractJournalEvent<ModuleSellBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ModuleSellBean.class;
	}
	
	protected void processBean(ModuleSellBean bean) {
	}

}
	