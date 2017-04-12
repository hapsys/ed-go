package org.c3s.edgo.event.impl.beans;

import java.util.Date;

import org.c3s.edgo.event.AbstractEventBean;

public class MaterialsBean extends AbstractEventBean {

	private Date timestamp;
	private String event;
	/**
	 * 
	 */
	private NameCount[] Raw;
	private NameCount[] Manufactured;
	private NameCount[] Encoded;
	
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
	
	
	public NameCount[] getRaw() {
		return Raw;
	}

	public void setRaw(NameCount[] raw) {
		Raw = raw;
	}

	public NameCount[] getManufactured() {
		return Manufactured;
	}

	public void setManufactured(NameCount[] manufactured) {
		Manufactured = manufactured;
	}

	public NameCount[] getEncoded() {
		return Encoded;
	}

	public void setEncoded(NameCount[] encoded) {
		Encoded = encoded;
	}
	
	public class NameCount {
		
		private String Name;
		private int Count;
		
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		
	}


	
}
