package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.MaterialDiscoveredBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaterialDiscovered extends AbstractJournalEvent<MaterialDiscoveredBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = MaterialDiscoveredBean.class;
	}
	
	protected void processBean(MaterialDiscoveredBean bean) {
	}

}
	