package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MaterialDiscardedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaterialDiscarded extends AbstractJournalEvent<MaterialDiscardedBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MaterialDiscardedBean.class;
	}
	
	protected void processBean(MaterialDiscardedBean bean) {
	}

}
	