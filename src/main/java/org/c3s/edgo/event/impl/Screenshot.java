package org.c3s.edgo.event.impl;
	
import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.ScreenshotBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Screenshot extends AbstractJournalEvent<ScreenshotBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LoadGame.class);
	
	{
		beanClass = ScreenshotBean.class;
	}
	
	protected void processBean(ScreenshotBean bean) {
	}

}
	