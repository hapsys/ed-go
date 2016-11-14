package org.c3s.edgo.scripts;

import com.google.gson.annotations.SerializedName;

public class EddbModuleInfo {

	public int id;
	public int group_id;
	@SerializedName("class")
	public int _class;
	public String rating;
	public int ed_id;
	public String name;
	public String ed_symbol;
	public String ship;
	public Group group;
	
	public static class Group {
		public int id;
		public int category_id;
		public String name;
		public String category;
	}
}
