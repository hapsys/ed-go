package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.PowerplayVoucherBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerplayVoucher extends AbstractJournalEvent<PowerplayVoucherBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = PowerplayVoucherBean.class;
	}
	
	protected void processBean(PowerplayVoucherBean bean) {
	}

}
	