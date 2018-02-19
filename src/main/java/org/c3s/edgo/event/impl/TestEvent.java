package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.annotation.EventAnnotation;
import org.c3s.edgo.event.impl.beans.DiedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EventAnnotation("TestEventSomeClass")
public class TestEvent extends AbstractJournalEvent<DiedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = DiedBean.class;
	}
	
	protected void processBean(DiedBean bean) {
	}

}
	