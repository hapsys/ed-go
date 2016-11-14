package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.EngineerApplyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineerApply extends AbstractJournalEvent<EngineerApplyBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = EngineerApplyBean.class;
	}
	
	protected void processBean(EngineerApplyBean bean) {
	}

}
	