package org.c3s.edgo.scripts.check;

public class TestEventTime {

	public static void main(String[] args) {
		String event = "{ \"timestamp\":\"2017-12-03T07:55:26Z\", \"event\":\"Friends\", \"Status\":\"Online\", \"Name\":\"AlleX86\" }";
		String eventTime = event.substring(15, 35);
		System.out.println(eventTime);
	}

}
