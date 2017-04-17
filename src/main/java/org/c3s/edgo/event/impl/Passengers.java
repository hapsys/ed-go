package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PassengersBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Passengers extends AbstractJournalEvent<PassengersBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Passengers.class);
	
	{
		beanClass = PassengersBean.class;
	}
	
	protected void processBean(PassengersBean bean) {
	}

}
	