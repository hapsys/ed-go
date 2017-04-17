package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CrewMemberQuitsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrewMemberQuits extends AbstractJournalEvent<CrewMemberQuitsBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CrewMemberQuits.class);
	
	{
		beanClass = CrewMemberQuitsBean.class;
	}
	
	protected void processBean(CrewMemberQuitsBean bean) {
	}

}
	