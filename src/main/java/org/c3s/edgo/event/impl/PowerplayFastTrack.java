package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayFastTrackBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayFastTrack extends AbstractJournalEvent<PowerplayFastTrackBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayFastTrackBean.class;
	}
	
	protected void processBean(PowerplayFastTrackBean bean) {
	}

}
	