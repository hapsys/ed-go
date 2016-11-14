package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayDefectBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayDefect extends AbstractJournalEvent<PowerplayDefectBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayDefectBean.class;
	}
	
	protected void processBean(PowerplayDefectBean bean) {
	}

}
	