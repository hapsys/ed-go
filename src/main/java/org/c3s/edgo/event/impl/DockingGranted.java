package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DockingGrantedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DockingGranted extends AbstractJournalEvent<DockingGrantedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DockingGrantedBean.class;
	}
	
	protected void processBean(DockingGrantedBean bean) {
	}

}
	