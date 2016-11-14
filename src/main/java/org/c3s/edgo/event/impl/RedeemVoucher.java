package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.RedeemVoucherBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedeemVoucher extends AbstractJournalEvent<RedeemVoucherBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = RedeemVoucherBean.class;
	}
	
	protected void processBean(RedeemVoucherBean bean) {
	}

}
	