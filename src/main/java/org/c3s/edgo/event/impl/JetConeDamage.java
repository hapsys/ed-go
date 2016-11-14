package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.JetConeDamageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JetConeDamage extends AbstractJournalEvent<JetConeDamageBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = JetConeDamageBean.class;
	}
	
	protected void processBean(JetConeDamageBean bean) {
	}

}
	