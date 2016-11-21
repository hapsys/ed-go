package org.c3s.edgo.event.impl.beans;

import java.util.Date;

public class ReceiveTextBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private String From;
	/**
	 * 
	 */
	private String Message;
	/**
	 *  (wing/local/voicechat/friend/player/npc)
	 */
	private String Channel;
	
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
	public String getFrom() {
		return From;
	}
	/**
	 * @param from
	 */
	public void setFrom(String from) {
		this.From = from;
	}
	/**
	 * @return
	 */
	public String getMessage() {
		return Message;
	}
	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.Message = message;
	}
	/**
	 * @return
	 */
	public String getChannel() {
		return Channel;
	}
	/**
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.Channel = channel;
	}
	
}	
	