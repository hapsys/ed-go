package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.VehicleSwitchBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VehicleSwitch extends AbstractJournalEvent<VehicleSwitchBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = VehicleSwitchBean.class;
	}
	
	protected void processBean(VehicleSwitchBean bean) {
	}

}
	