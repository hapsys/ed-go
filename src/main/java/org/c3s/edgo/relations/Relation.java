package org.c3s.edgo.relations;

public enum Relation {

	ANY		(0b1),
	LOGGED	(0b10),
	FRIEND	(0b100),
	WING	(0b1000),
	GROUP	(0b10000),
	;
	
	long mask = 0;
	private Relation(long mask) {
		this.mask = mask;
	}
}
