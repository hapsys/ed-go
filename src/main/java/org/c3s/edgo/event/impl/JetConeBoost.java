package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.JetConeBoostBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JetConeBoost extends AbstractJournalEvent<JetConeBoostBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = JetConeBoostBean.class;
	}
	
	protected void processBean(JetConeBoostBean bean) {
	}

}
	