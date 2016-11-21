package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="events")
@NamedQueries({
	@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e"),
	@NamedQuery(name="Event.findUnlocked", query="SELECT e FROM Event e WHERE e.isLocked = 0 ORDER BY e.eventId"),
})
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	private long eventId;

	@Lob
	@Column(name="event_json")
	private String eventJson;

	@Column(name="is_locked")
	private byte isLocked;

	@Column(name="user_id")
	private int userId;


	@Column(name="event_name")
	private String eventName;
	
	public Event() {
	}

	public long getEventId() {
		return this.eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventJson() {
		return this.eventJson;
	}

	public void setEventJson(String eventJson) {
		this.eventJson = eventJson;
	}

	public byte getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(byte isLocked) {
		this.isLocked = isLocked;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	
}