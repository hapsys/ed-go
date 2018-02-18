package org.c3s.edgo.event;

public class EventDateRange {

	private String startDate = null;
	private String endDate = null;
	
	public EventDateRange(String startDate, String endDate) {
		this.startDate = (startDate != null)? startDate:"2000-01-01T00:00:00Z";
		this.endDate = (endDate != null)? endDate:"3000-01-01T00:00:00Z";
	}
	
	public EventDateRange(String endDate) {
		this(null, endDate);
	}

	public EventDateRange() {
		this(null, null);
	}
	
	public boolean compareRange(String date) {
		int cmpStart = this.startDate.compareTo(date);
		int cmpEnd = this.endDate.compareTo(date);
		return cmpStart <= 0 && cmpEnd > 0; 
	}
}
