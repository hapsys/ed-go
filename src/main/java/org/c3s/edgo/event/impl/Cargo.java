package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CargoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cargo extends AbstractJournalEvent<CargoBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Cargo.class);
	
	{
		beanClass = CargoBean.class;
	}
	
	protected void processBean(CargoBean bean) {
	}

}
	