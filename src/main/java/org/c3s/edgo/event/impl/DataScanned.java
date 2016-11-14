package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DataScannedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataScanned extends AbstractJournalEvent<DataScannedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DataScannedBean.class;
	}
	
	protected void processBean(DataScannedBean bean) {
	}

}
	