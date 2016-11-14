package org.c3s.edgo.event.impl;

import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.LoadGameBean;
import org.c3s.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadGame extends AbstractJournalEvent<LoadGameBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = LoadGameBean.class;
	}
	
	protected void processBean(LoadGameBean bean) {
		
		try {
			System.out.println(bean);
			System.out.println(Utils.mapToString(mapper.mapToRow(bean), ""));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
