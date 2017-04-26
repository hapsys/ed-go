package org.c3s.edgo.relations;

import java.util.ArrayList;
import java.util.List;

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
	
	public long getMask() {
		return mask;
	}
	
	public static Relation[] getRelations(long relation) {
		List<Relation> result = new ArrayList<Relation>();
		for(Relation rel: values()) {
			if ((relation & rel.getMask()) != 0) {
				result.add(rel);
			}
		}
		return result.toArray(new Relation[]{});
	}
}
