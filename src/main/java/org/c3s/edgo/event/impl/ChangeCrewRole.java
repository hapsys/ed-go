package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ChangeCrewRoleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeCrewRole extends AbstractJournalEvent<ChangeCrewRoleBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ChangeCrewRole.class);
	
	{
		beanClass = ChangeCrewRoleBean.class;
	}
	
	protected void processBean(ChangeCrewRoleBean bean) {
	}

}
	