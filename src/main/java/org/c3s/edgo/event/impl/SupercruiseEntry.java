package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SupercruiseEntryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupercruiseEntry extends AbstractJournalEvent<SupercruiseEntryBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SupercruiseEntryBean.class;
	}
	
	protected void processBean(SupercruiseEntryBean bean) {
	}

}
	