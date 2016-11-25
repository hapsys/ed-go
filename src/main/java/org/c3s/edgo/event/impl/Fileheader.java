package org.c3s.edgo.event.impl;

import org.c3s.edgo.event.AbstractJournalEvent;
import org.c3s.edgo.event.impl.beans.FileheaderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fileheader extends AbstractJournalEvent<FileheaderBean> {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(Fileheader.class);
	
	{
		beanClass = FileheaderBean.class;
	}
	
	protected void processBean(FileheaderBean bean) {
	}

}
