package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.HeatWarningBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeatWarning extends AbstractJournalEvent<HeatWarningBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = HeatWarningBean.class;
	}
	
	protected void processBean(HeatWarningBean bean) {
	}

}
	