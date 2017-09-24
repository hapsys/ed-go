package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class ScreenshotBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * filename of screenshot
	 */
	private String Filename;
	/**
	 * size in pixels
	 */
	private Long	Width;
	/**
	 * size in pixels
	 */
	private Long Height;
	/**
	 * current star system
	 */
	private String System;
	/**
	 * name of nearest body
	 */
	private String Body;

	private String Src;
	
	/**
	 * @return
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return
	 */
	public String getFilename() {
		return Filename;
	}

	/**
	 * @param filename
	 */
	public void setFilename(String filename) {
		this.Filename = filename;
	}

	/**
	 * @return
	 */
	public Long getWidth() {
		return Width;
	}

	/**
	 * @param width
	 */
	public void setWidth(Long width) {
		this.Width = width;
	}

	/**
	 * @return
	 */
	public Long getHeight() {
		return Height;
	}

	/**
	 * @param height
	 */
	public void setHeight(Long height) {
		this.Height = height;
	}

	/**
	 * @return
	 */
	public String getSystem() {
		return System;
	}

	/**
	 * @param system
	 */
	public void setSystem(String system) {
		this.System = system;
	}

	/**
	 * @return
	 */
	public String getBody() {
		return Body;
	}

	/**
	 * @param body
	 */
	public void setBody(String body) {
		this.Body = body;
	}

	public String getSrc() {
		return Src;
	}

	public void setSrc(String src) {
		Src = src;
	}

	
}
