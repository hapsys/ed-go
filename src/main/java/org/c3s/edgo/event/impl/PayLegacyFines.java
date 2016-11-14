package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PayLegacyFinesBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayLegacyFines extends AbstractJournalEvent<PayLegacyFinesBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PayLegacyFinesBean.class;
	}
	
	protected void processBean(PayLegacyFinesBean bean) {
	}

}
	