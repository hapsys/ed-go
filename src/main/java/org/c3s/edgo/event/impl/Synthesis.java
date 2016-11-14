package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.SynthesisBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Synthesis extends AbstractJournalEvent<SynthesisBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = SynthesisBean.class;
	}
	
	protected void processBean(SynthesisBean bean) {
	}

}
	