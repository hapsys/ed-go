package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.KickCrewMemberBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KickCrewMember extends AbstractJournalEvent<KickCrewMemberBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(KickCrewMember.class);
	
	{
		beanClass = KickCrewMemberBean.class;
	}
	
	protected void processBean(KickCrewMemberBean bean) {
	}

}
	