package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleSellRemoteBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleSellRemote extends AbstractJournalEvent<ModuleSellRemoteBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ModuleSellRemoteBean.class;
	}
	
	protected void processBean(ModuleSellRemoteBean bean) {
	}

}
	