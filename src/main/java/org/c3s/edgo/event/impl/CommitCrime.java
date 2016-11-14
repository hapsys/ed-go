package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.CommitCrimeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommitCrime extends AbstractJournalEvent<CommitCrimeBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = CommitCrimeBean.class;
	}
	
	protected void processBean(CommitCrimeBean bean) {
	}

}
	