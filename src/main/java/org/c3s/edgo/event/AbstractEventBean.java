package org.c3s.edgo.event;

import java.util.Date;

public abstract class AbstractEventBean {

	/**
	 * @return
	 */
	public abstract Date getTimestamp();
	
	/**
	 * @return
	 */
	public abstract void setTimestamp(Date timestamp);
	
	/**
	 * @return
	 */
	public abstract String getEvent();
	
}
