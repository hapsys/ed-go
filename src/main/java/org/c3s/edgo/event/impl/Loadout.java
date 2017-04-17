package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LoadoutBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loadout extends AbstractJournalEvent<LoadoutBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Loadout.class);
	
	{
		beanClass = LoadoutBean.class;
	}
	
	protected void processBean(LoadoutBean bean) {
	}

}
	