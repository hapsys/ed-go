package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MiningRefinedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiningRefined extends AbstractJournalEvent<MiningRefinedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MiningRefinedBean.class;
	}
	
	protected void processBean(MiningRefinedBean bean) {
	}

}
	