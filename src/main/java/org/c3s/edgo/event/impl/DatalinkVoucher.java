package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.DatalinkVoucherBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatalinkVoucher extends AbstractJournalEvent<DatalinkVoucherBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DatalinkVoucherBean.class;
	}
	
	protected void processBean(DatalinkVoucherBean bean) {
	}

}
	