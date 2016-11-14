package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ModuleBuyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleBuy extends AbstractJournalEvent<ModuleBuyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ModuleBuyBean.class;
	}
	
	protected void processBean(ModuleBuyBean bean) {
	}

}
	