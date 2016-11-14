package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FuelScoopBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FuelScoop extends AbstractJournalEvent<FuelScoopBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = FuelScoopBean.class;
	}
	
	protected void processBean(FuelScoopBean bean) {
	}

}
	