package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ScientificResearchBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScientificResearch extends AbstractJournalEvent<ScientificResearchBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ScientificResearchBean.class;
	}
	
	protected void processBean(ScientificResearchBean bean) {
	}

}
	