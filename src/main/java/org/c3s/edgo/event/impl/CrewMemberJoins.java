package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CrewMemberJoinsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrewMemberJoins extends AbstractJournalEvent<CrewMemberJoinsBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CrewMemberJoins.class);
	
	{
		beanClass = CrewMemberJoinsBean.class;
	}
	
	protected void processBean(CrewMemberJoinsBean bean) {
	}

}
	