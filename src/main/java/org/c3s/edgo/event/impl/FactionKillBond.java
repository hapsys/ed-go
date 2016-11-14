package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FactionKillBondBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactionKillBond extends AbstractJournalEvent<FactionKillBondBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = FactionKillBondBean.class;
	}
	
	protected void processBean(FactionKillBondBean bean) {
	}

}
	