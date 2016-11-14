package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplaySalaryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplaySalary extends AbstractJournalEvent<PowerplaySalaryBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplaySalaryBean.class;
	}
	
	protected void processBean(PowerplaySalaryBean bean) {
	}

}
	