package org.c3s.edgo.relations;

import java.util.ArrayList;
import java.util.List;

import org.c3s.reflection.annotation.XMLSimple;

public enum Relation {

	UNKNOWN	(0b1),
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
	
	public static List<RelationNameValue> getList() {
		List<RelationNameValue> result = new ArrayList<RelationNameValue>();
			for(Relation rel: values()) {
				result.add(new RelationNameValue(rel.mask, rel.name()));
			}
		return result;
	}

	public static class RelationNameValue {
		@XMLSimple("value")
		private long value = 0;
		@XMLSimple("name")
		private String name = "";
		public RelationNameValue(long value, String name) {
			super();
			this.value = value;
			this.name = name;
		}
		public long getValue() {
			return value;
		}
		public String getName() {
			return name;
		}
	}
}
