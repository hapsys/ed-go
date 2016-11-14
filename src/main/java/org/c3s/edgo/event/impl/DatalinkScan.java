package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DatalinkScanBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatalinkScan extends AbstractJournalEvent<DatalinkScanBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DatalinkScanBean.class;
	}
	
	protected void processBean(DatalinkScanBean bean) {
	}

}
	