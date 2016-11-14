package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RestockVehicleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestockVehicle extends AbstractJournalEvent<RestockVehicleBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RestockVehicleBean.class;
	}
	
	protected void processBean(RestockVehicleBean bean) {
	}

}
	