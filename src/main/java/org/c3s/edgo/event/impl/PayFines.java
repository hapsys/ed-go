package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PayFinesBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayFines extends AbstractJournalEvent<PayFinesBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PayFinesBean.class;
	}
	
	protected void processBean(PayFinesBean bean) {
	}

}
	